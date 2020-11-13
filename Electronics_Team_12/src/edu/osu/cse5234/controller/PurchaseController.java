package edu.osu.cse5234.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.sun.org.apache.bcel.internal.generic.NEW;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	private InventoryService inventoryService;
	private OrderProcessingServiceBean orderService;
	
	public PurchaseController() {
		inventoryService = ServiceLocator.getInventoryService();
		orderService = ServiceLocator.getOrderProcessingService();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Order order = new Order();
		
		Inventory inventory = inventoryService.getAvailableInventory();
		request.setAttribute("inventory", inventory);
		
		List<Item> items = inventory.getItems();
		List<LineItem> lineItems = new ArrayList<>();
		
		for (Item item : items) {
//			item.setQuantity(0);
			order.addItem(new LineItem());
			//order.addItem(item);
		}
		
		request.getSession().setAttribute("order", order);
		request.setAttribute("order", order);
		request.getSession().setAttribute("isValid", true);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public ModelAndView submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		
		if (orderService.validateItemAvailability(order)) {
			return new ModelAndView("redirect:/purchase/paymentEntry");
		} else {
			request.getSession().setAttribute("isValid", false);
			ModelMap mapper = new ModelMap("message", "Quantity unavailable, kindly re-enter quantities.");
			Inventory inventory = ServiceLocator.getInventoryService().getAvailableInventory();
			request.setAttribute("inventory", inventory);
			return new ModelAndView("OrderEntryForm", mapper);
		}
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String displayPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) {
//		Order order = (Order) request.getSession().getAttribute("order");
//		order.setPaymentInfo(new PaymentInfo());
		
//		request.getSession().setAttribute("order", order);
		request.setAttribute("payment", new PaymentInfo());
		
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		Order order = (Order) request.getSession().getAttribute("order");
		order.setPaymentInfo(payment);
		order.setCustomerName(payment.getCardholderName());
		order.setEmailAddress("abc@gmail.com");
//		request.getSession().setAttribute("order", order);
		
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String displayShippingForm(HttpServletRequest request, HttpServletResponse response) {
//		Order order = (Order) request.getSession().getAttribute("order");
//		order.setShippingInfo(new ShippingInfo());
//		
//		request.getSession().setAttribute("order", order);
		request.setAttribute("shipping", new ShippingInfo());
		
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShippingInfo(@ModelAttribute("shipping") ShippingInfo info, HttpServletRequest request) {
//		request.getSession().setAttribute("shipping", info);
		Order order = (Order) request.getSession().getAttribute("order");
		order.setShippingInfo(info);
		
//		request.getSession().setAttribute("order", order);
		
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request) {
		Order order = (Order) request.getSession().getAttribute("order");
//		System.out.println(order == null);
		String confirmationNumber = ServiceLocator.getOrderProcessingService().processOrder(order);
		request.getSession().setAttribute("confirmationID", confirmationNumber);
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation";
	}
}

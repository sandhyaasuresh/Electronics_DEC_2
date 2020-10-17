package edu.osu.cse5234.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Order order = new Order();
		
		Item item1 = new Item("OnePlus 7T", "699.99", "0");
		Item item2 = new Item("Dell xps 13in", "1349.99", "0");
		Item item3 = new Item("Samsung s20", "999.99", "0");
		Item item4 = new Item("Pixel 5", "729.99", "0");
		Item item5 = new Item("Lenovo Thinkpad", "1499.99", "0");
		
		order.addItem(item1);
		order.addItem(item2);
		order.addItem(item3);
		order.addItem(item4);
		order.addItem(item5);
		
		request.getSession().setAttribute("order", order);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String displayPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());
		
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String displayShippingForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());
		
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShippingInfo(@ModelAttribute("shipping") ShippingInfo info, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", info);
		
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request) {
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation";
	}
}

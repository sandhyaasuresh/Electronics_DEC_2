package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.PaymentInfo;

@Controller("/")
@RequestMapping("/")

public class RootController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "HomeJSP";
	}
	
	@RequestMapping(path = "/aboutUs", method = RequestMethod.GET)
	public String aboutUsPage(HttpServletRequest request, HttpServletResponse response) {
		return "AboutUsJSP";
	}
	
	@RequestMapping(path = "/contactUs", method = RequestMethod.GET)
	public String contactUsPage(HttpServletRequest request, HttpServletResponse response) {
		return "ContactJSP";
	}
}

package com.biz.pat.controller;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.pat.service.PetService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	PetService pService;
	
	@RequestMapping(value = "/",
		method = RequestMethod.GET,
		produces = "text/json;charset=UTF-8")
	public String home(Locale locale, Model model) throws URISyntaxException {
		
		return "redirect:/pet";
	}
	
}

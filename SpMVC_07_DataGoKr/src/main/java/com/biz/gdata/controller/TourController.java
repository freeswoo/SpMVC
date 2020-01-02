package com.biz.gdata.controller;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.gdata.service.TourSimpleService;

@Controller
public class TourController {

	@Autowired
	TourSimpleService tService;

	@RequestMapping(value = "total", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String total(Model model) {

		JSONArray jArray = null;
		try {
			jArray = tService.getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("CITY", jArray);
		return "home";

	}

	@ResponseBody
	@RequestMapping(value = "city", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String city(Model model) {

		String cityString = null;
		try {
			cityString = tService.getDataString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cityString;

	}

}

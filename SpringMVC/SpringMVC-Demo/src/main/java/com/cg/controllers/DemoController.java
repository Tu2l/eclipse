package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/frontcontroller")
public class DemoController {

	
	@RequestMapping("/")
	public String index() {
		return "hello";
	}

	@ResponseBody
	@RequestMapping("/hello/{id}")
	public String helloUser(@PathVariable("id") String id) {
		return "Welcome " + id;
	}
	
	
	@RequestMapping("/studform")
	public ModelAndView getStudForm() {
		return new ModelAndView("studentForm");
	}
	
	@RequestMapping(value="/submitform")
	public ModelAndView submitForm(@RequestParam("stuName") String studName, @RequestParam("subject")String subject) {
		ModelAndView mv = new ModelAndView("submitForm");
		mv.addObject("studData",studName+" "+subject);
		return mv;
	}
}

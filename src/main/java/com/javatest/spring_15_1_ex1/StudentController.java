package com.javatest.spring_15_1_ex1;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	
	@RequestMapping(value="/login")
	public String login() {
		
		return "login";
	}

	@RequestMapping(value = "/loginOk")
	public String loginok(@ModelAttribute Student student, BindingResult result) {
		String page = "loginOk";
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		
		if(result.hasErrors()) {
			page = "login";
		}
		
		return page;
	}
}

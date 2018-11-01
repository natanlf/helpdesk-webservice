package com.natanlf.helpdesk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstSpringBootController {

	@RequestMapping("/showtext")
		public String showText(){
		return "Hello";
	}
}

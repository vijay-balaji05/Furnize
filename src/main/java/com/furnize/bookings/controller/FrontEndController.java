package com.furnize.bookings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {
	
	@GetMapping()
	public String reDirect() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home.html";
	}

}

package com.eShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/admins")
	public String admins() {
		return "admins";
	}
	@GetMapping("/user")
	public String users() {
		return "user";
	}

}

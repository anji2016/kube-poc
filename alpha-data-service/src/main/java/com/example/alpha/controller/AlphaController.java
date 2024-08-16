package com.example.alpha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alpha")
public class AlphaController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Alpha!!";
	}
}

package com.example.beta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beta")
public class BetaController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Beta!!";
	}
}

package com.as.apicore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController
{
@GetMapping("/greet")
public String hello() {
		return "Hello";
	}
}

package com.kk.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//	@Value("${welcome.message}")
//    private String welcomeMesssage;
	
	@Value("${hello.message}")
	private String helloWorld;
	
	@GetMapping("/")
	public String getHelloWorld() {
		return helloWorld;
	}
}

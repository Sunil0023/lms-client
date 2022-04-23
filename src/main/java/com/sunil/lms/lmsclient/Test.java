package com.sunil.lms.lmsclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@GetMapping("/hello/{name}")
	public String helloTest(@PathVariable String name) {
		return "Wow!!! "+name;
	}

}

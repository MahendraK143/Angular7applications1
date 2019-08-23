package com.sb.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.User;

@RestController
public class TestController {
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String getMethod(){
		return "Test";
	}
	@RequestMapping(value="/post",method=RequestMethod.POST)
	public String post(@RequestBody User user){
		System.out.println(user);
		return "Test";
	}
	
}

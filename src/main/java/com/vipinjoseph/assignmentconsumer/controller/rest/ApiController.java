package com.vipinjoseph.assignmentconsumer.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipinjoseph.assignmentconsumer.entity.Values;
import com.vipinjoseph.assignmentconsumer.service.ValueServices;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ValueServices valueService;
	
	@GetMapping("/list")
	public List<Values> list() {
		return valueService.getAllValues();
	}
	
	

}

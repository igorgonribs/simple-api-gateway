package com.patterns.architecture.servicetwo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("servicetwo")
public class ServiceTwoController {

	@GetMapping
	public ResponseEntity<Map<String, Object>> getServiceOne() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("messageServiceTwo", "Service Two is up");
		return ResponseEntity.ok(response);
	}
}
package com.patterns.architecture.serviceone.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("serviceone")
public class ServiceOneController {

	@GetMapping
	public ResponseEntity<Map<String, Object>> getServiceOne() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("messageServiceOne", "Service One is up");
		return ResponseEntity.ok(response);
	}
}

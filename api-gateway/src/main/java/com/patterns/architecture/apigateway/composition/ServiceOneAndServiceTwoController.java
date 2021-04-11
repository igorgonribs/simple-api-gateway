package com.patterns.architecture.apigateway.composition;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patterns.architecture.apigateway.serviceone.ServiceOneClient;
import com.patterns.architecture.apigateway.servicetwo.ServiceTwoClient;

@RestController
public class ServiceOneAndServiceTwoController {

	@Autowired
	private ServiceOneClient serviceOneClient;
	
	@Autowired
	private ServiceTwoClient serviceTwoClient;
	
	@GetMapping("/serviceone-and-servicetwo")
	public ResponseEntity<Map<String, Object>> getServiceOneAndServiceTwo() {
		
		Map<String, Object> response = serviceOneClient.callServiceOne();
		response.putAll(serviceTwoClient.callServiceTwo());
		
		return ResponseEntity.ok(response);
	}
}

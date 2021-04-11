package com.patterns.architecture.apigateway.servicetwo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceTwoClientImpl implements ServiceTwoClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${zuul.routes.servicetwo.url}")
	private String urlServiceTwo;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> callServiceTwo() {
		String url = this.urlServiceTwo + "/servicetwo";
		return restTemplate.getForObject(url, Map.class);
	}

}

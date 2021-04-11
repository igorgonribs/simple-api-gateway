package com.patterns.architecture.apigateway.serviceone;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceOneClientImpl implements ServiceOneClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${zuul.routes.serviceone.url}")
	private String urlServiceOne;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> callServiceOne() {
		String url = this.urlServiceOne + "/serviceone";
		return restTemplate.getForObject(url, Map.class);
	}

}

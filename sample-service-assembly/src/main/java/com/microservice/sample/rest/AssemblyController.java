package com.microservice.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.sample.client.SampleServiceOneProxy;
import com.microservice.sample.client.SampleServiceTwoProxy;

@RestController
@RefreshScope
public class AssemblyController {

	@Autowired
	private SampleServiceOneProxy serviceOneProxy;

	@Autowired
	private SampleServiceTwoProxy serviceTwoProxy;

	@Autowired
	private PortListener portListener;

	@Value("${spring.application.name}")
	private String appName;

	@RequestMapping("/")
	public String defaultEndPoint() {
		String payload = "I'm " + appName + " And I'm running on port: " + portListener.port + "\n";
		payload += "I can show you other running services below :- \n";
		payload += "- " + serviceOneProxy.retrieve() + "\n";
		payload += "- " + serviceTwoProxy.retrieve() + "\n";
		return payload;
	}
}

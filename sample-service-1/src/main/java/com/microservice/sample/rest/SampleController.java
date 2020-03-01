package com.microservice.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
@RefreshScope
public class SampleController {
//
	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private PortListener portListener;

//	@Autowired
//    @Lazy
//    private EurekaClient eurekaClient;

	@RequestMapping("/")
	public String defaultEndPoint() {
		return "I'm " + appName + " And I'm running on port: " + portListener.port;
	}
}

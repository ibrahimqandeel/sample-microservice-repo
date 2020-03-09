package com.microservice.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.sample.client.FeignClientProxy;

@RestController
@RefreshScope
public class AssemblyController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FeignClientProxy clientProxy;

	@Autowired
	private PortListener portListener;

	@Value("${spring.application.name}")
	private String appName;

	@RequestMapping("/")
	public String defaultEndPoint() {
		StringBuilder payload = new StringBuilder(
				"I'm " + appName + " And I'm running on port: " + portListener.port + "\n");
		payload.append("I can show you other running services below :- \n");
		payload.append("\n- " + clientProxy.sampleService1() + "\n");
		payload.append("\n- " + clientProxy.sampleService2() + "\n");
		logger.info("{}", "log info ---> Response from ---> " + appName + ":" + portListener.port);
		return payload.toString();
	}
}

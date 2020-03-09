package com.microservice.sample.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SampleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private PortListener portListener;

//	@Autowired
//    @Lazy
//    private EurekaClient eurekaClient;

	@RequestMapping("/")
	public String defaultEndPoint() {
		logger.info("{}", "log info ---> Response from ---> " + appName + ":" + portListener.port);
		return "I'm " + appName + " And I'm running on port: " + portListener.port;
	}
}

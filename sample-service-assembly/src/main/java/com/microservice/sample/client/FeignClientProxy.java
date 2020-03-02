package com.microservice.sample.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zuul-gateway-server")
//@RibbonClient(name = "sample-service-1")//Zuul uses Ribbon by default
public interface FeignClientProxy {

	@RequestMapping("/sample-service-1")
	public String sampleService1();
	
	@RequestMapping("/sample-service-2")
	public String sampleService2();
}

package com.microservice.sample.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zuul-gateway-server")
//@RibbonClient(name = "sample-service-2")//Zuul uses Ribbon by default
public interface SampleServiceTwoProxy {

	@RequestMapping("/sample-service-2")
	public String retrieve();
}

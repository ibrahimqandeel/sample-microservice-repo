package com.microservice.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
public class SampleService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleService1Application.class, args);
	}

}
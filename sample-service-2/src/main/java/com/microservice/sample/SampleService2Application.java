package com.microservice.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class SampleService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleService2Application.class, args);
	}

	@Bean
	// creating a sampler called
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}

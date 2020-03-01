package com.microservice.sample.rest;

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

	public static int port;
	@Override
	public void onApplicationEvent(ServletWebServerInitializedEvent event) {
		// TODO Auto-generated method stub
		port = event.getWebServer().getPort();
	}

}

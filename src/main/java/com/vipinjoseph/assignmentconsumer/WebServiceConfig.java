package com.vipinjoseph.assignmentconsumer;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	@Autowired
	private ValueServices ValueServices;
	
	@Bean
	public Endpoint endPoint() {
		Endpoint endpoint = new EndpointImpl(bus, new SoapController(ValueServices));
		endpoint.publish("/gcdlist");
		return endpoint;
	}

}

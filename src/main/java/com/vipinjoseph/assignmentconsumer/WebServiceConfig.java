package com.vipinjoseph.assignmentconsumer;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vipinjoseph.assignmentconsumer.config.UTPasswordCallback;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	@Autowired
	private ValueServices ValueServices;
	
	@Bean
	public Endpoint endPoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new SoapController(ValueServices));
		endpoint.publish("/gcd");
		
		addSecurityInterceptorToEndPoin(endpoint);
		
		return endpoint;
	}

	private void addSecurityInterceptorToEndPoin(EndpointImpl endpoint) {
		Map<String, Object> inProps = new HashMap<>();
		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		
		WSS4JInInterceptor wssInterceptor = new WSS4JInInterceptor(inProps);
		endpoint.getInInterceptors().add(wssInterceptor);
	}

}

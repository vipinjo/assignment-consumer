package com.vipinjoseph.assignmentconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ValueProcessor {
	
	private final ObjectMapper objectMapper;
	private final ValueServices valueServices;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValueProcessor.class);
	
	@Autowired
	public ValueProcessor(ObjectMapper objectMapper, ValueServices valueServices ) {
		super();
		this.objectMapper = objectMapper;
		this.valueServices = valueServices;
	}
	
	public void receiveMessage(String valuesJson) {
		LOGGER.info("Message Received");
		
		try {
			Values values = this.objectMapper.readValue(valuesJson, Values.class);
			valueServices.save(values);
		} catch (Exception exc) {
			LOGGER.error("Exception caught", exc);
		}
	}

}

package com.vipinjoseph.assignmentconsumer;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

import com.vipinjoseph.assignmentconsumer.exceptions.ServiceException;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class SoapController {
	
	private ValueServices valueService;
	
	public SoapController(ValueServices valueService) {
		this.valueService = valueService;
	}
	
	@WebMethod
	public List<Integer> getGcdList() {
		return valueService.getGcdList();
	}
	
	@WebMethod
	public Integer getGcd() throws ServiceException {
		return valueService.getGcd();
	}
	
	@WebMethod
	public Integer getGcdSum() {
		return valueService.getGcdSum();
	}
	
	

}

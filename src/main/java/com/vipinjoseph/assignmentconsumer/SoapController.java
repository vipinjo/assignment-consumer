package com.vipinjoseph.assignmentconsumer;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

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
	public Values getGcd() {
		//TODO: Throw soap fault if no values exists
		return valueService.getGcd();
	}
	
	@WebMethod
	public Integer getGcdSum() {
		return valueService.getGcdSum();
	}
	
	

}

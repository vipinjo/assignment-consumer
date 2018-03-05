package com.vipinjoseph.assignmentconsumer.utils;

public class GcdUtils {
	
	public static int getGCD(int valueOne, int valueTwo) {
		valueOne = (valueOne > 0) ? valueOne : -valueOne;
		valueTwo = (valueTwo > 0) ? valueTwo : -valueTwo;
		
		while (valueOne != valueTwo) {
			if (valueOne > valueTwo)
				valueOne -= valueTwo;
			else 
				valueTwo -= valueOne;
		}
		
		return valueOne;
	}

}

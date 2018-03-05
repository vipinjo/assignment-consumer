package com.vipinjoseph.assignmentconsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueServices {
	
	private ValuesRepository valuesRepository;
	
	private Queue<Values> queue;

	@Autowired
	public ValueServices(ValuesRepository valuesRepository) {
		super();
		this.valuesRepository = valuesRepository;
		this.queue = new LinkedList<Values>();
	}
	
	public List<Values> getAllValues() {
		List<Values> values = new ArrayList<>();
		this.valuesRepository.findAll().forEach(values::add);
		return values;
	}
	
	public void save(Values values) {
		this.valuesRepository.save(values);
		if (queue == null) {
			queue = new LinkedList<Values>();
		}
		queue.add(values);
	}
	
	public List<Integer> getGcdList() {
		List<Values> valuesList = new ArrayList<>();
		this.valuesRepository.findAll().forEach(valuesList::add);
		List<Integer> gcdList = createGcdList(valuesList);  
		return gcdList;
	}
	
	public Values getGcd() {
		Values values = null;
		if (!queue.isEmpty()) {
		    values = queue.remove();
		}
		return values;
	}
	
	public int getGcdSum() {
		List<Integer> gcdList = getGcdList();
		int sum = 0;
		for (int gcd:gcdList) {
			sum = sum + gcd;
		}
		return sum;
		
	}

	private List<Integer> createGcdList(List<Values> valuesList) {
		List<Integer> gcdList = new ArrayList<>();
		for (Values values : valuesList) {
			gcdList.add(GcdUtils.getGCD(values.getValueOne(), values.getValueTwo())); 
		}

		return gcdList;
	}
	
    

}

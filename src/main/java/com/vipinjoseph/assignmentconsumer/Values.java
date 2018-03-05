package com.vipinjoseph.assignmentconsumer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INPUT_VALUES")
public class Values {
	@Id
	@Column(name="ID")
	@GeneratedValue
	private long id;
	
	@Column(name="VALUE_ONE")
	private int valueOne;
	
	@Column(name="VALUE_TWO")
    private int valueTwo;
	
	public Values() {
		super();
	}
	
	public Values(int valueOne, int valueTwo) {
		super();
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	public int getValueOne() {
		return valueOne;
	}

	public void setValueOne(int valueOne) {
		this.valueOne = valueOne;
	}

	public int getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(int valueTwo) {
		this.valueTwo = valueTwo;
	}

}

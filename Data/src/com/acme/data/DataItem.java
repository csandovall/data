package com.acme.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity public class DataItem {
	
	@Id String key;
	String value;

	public DataItem(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
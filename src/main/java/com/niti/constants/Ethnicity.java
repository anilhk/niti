package com.niti.constants;

import javax.activation.UnsupportedDataTypeException;

public enum Ethnicity {

	NATIVE_AMERICAN("0"),
	ASIAN("1"),
	AFRICAN_AMERICAN("2"),
	HISPANIC("3"),
	WHITE("4");

	private String name;
	
	private Ethnicity(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Ethnicity fromName(String name) throws UnsupportedDataTypeException {
		 
		for (Ethnicity ethnicty : Ethnicity.values()) {
				 if (ethnicty.getName().equals(name)) {
					 return ethnicty;
				 }
		 }
		throw new UnsupportedDataTypeException("value : " + name  +" not supported"); 
		
	}
	
	public String toString() {
		if (name.equals("2")) {
			return Constants.AFRICAN_AMERICAN;
		}
		else if (name.equals("1")) {
			return Constants.ASIAN;
		}
		else if (name.equals("3")) {
			return Constants.HISPANIC;
		}
		else if (name.equals("0")) {
			return Constants.NATIVE_AMERICAN;
		}
		else if (name.equals("4")) {
			return Constants.WHITE;
		}
		else {
			return null;
		}
	}
	
}

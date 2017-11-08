package com.niti.constants;

import javax.activation.UnsupportedDataTypeException;

public enum Gender {

	Male("M"),
	Female("F");
		
	private String name;

	private Gender(String name) {
		this.name = name;
	
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public static Gender fromName(String name) throws UnsupportedDataTypeException {
		 
		for (Gender gender : Gender.values()) {
				 if (gender.getName().equals(name)) {
					 return gender;
				 }
		 }
		throw new UnsupportedDataTypeException("value : " + name  +" not supported"); 
		
	}
	
	
}

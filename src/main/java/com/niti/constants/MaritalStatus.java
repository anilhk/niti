package com.niti.constants;

import javax.activation.UnsupportedDataTypeException;


public enum MaritalStatus {

	
	Single("Single"),
	Married("Married"),
	Seperated("Seperated"),
	Divorced("Divorced"),
	Widowed("Widowed");
	
	
	
	private String name; 
	
	private MaritalStatus(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static MaritalStatus fromName(String name) throws UnsupportedDataTypeException {
		
		for (MaritalStatus status : MaritalStatus.values()) {
				
				if (status.getName().equals(name)) {
					return status;	
				}
			
		}
		throw new UnsupportedDataTypeException("value : " + name  +" not supported"); 

		
	}
	

}

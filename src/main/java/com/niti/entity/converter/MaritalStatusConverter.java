package com.niti.entity.converter;

import javax.activation.UnsupportedDataTypeException;
import javax.persistence.AttributeConverter;

import com.niti.constants.MaritalStatus;

public class MaritalStatusConverter implements AttributeConverter<MaritalStatus, String> {

	@Override
	public String convertToDatabaseColumn(MaritalStatus value) {
				
		if (value == null) {
			return null;
		}
		return value.getName();
			
	}

	@Override
	public MaritalStatus convertToEntityAttribute(String value) {

		 if (value==null) {
			 return null;
		 }
		 try {
			return MaritalStatus.fromName(value);
		} catch (UnsupportedDataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}

package com.niti.entity.converter;

import javax.activation.UnsupportedDataTypeException;
import javax.persistence.AttributeConverter;


import com.niti.constants.Gender;

public class GenderConverter implements AttributeConverter<Gender, String > {

	@Override
	public String convertToDatabaseColumn(Gender value) {
		if (value==null) {
			return null;
		}
	    return value.getName();
	}

	@Override
	public Gender convertToEntityAttribute(String value) {
		
		 if (value==null) {
			 return null;
		 }else {
			 try {
				return Gender.fromName(value);
			} catch (UnsupportedDataTypeException e) {
				e.printStackTrace();
			}
		 }
		return null;
		
	}

	
}

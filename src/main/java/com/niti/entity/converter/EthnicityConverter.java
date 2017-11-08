package com.niti.entity.converter;

import javax.activation.UnsupportedDataTypeException;
import javax.persistence.AttributeConverter;

import com.niti.constants.Ethnicity;

public class EthnicityConverter implements AttributeConverter<Ethnicity,String>{

	@Override
	public String convertToDatabaseColumn(Ethnicity value) {
		if (value==null) {
			return null;
		}
	    return value.getName();
	}

	@Override
	public Ethnicity convertToEntityAttribute(String value) {

		 if (value==null) {
			 return null;
		 }
		 try {
			return Ethnicity.fromName(value);
		} catch (UnsupportedDataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
}

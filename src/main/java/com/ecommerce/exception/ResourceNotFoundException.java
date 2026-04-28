package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String resourcename;
	private String fieldname;
	private Object fieldValues;
	
	public ResourceNotFoundException(String resourcename, String fieldname, Object fieldValues) {
		super(String.format("%s not found with %s : '%s'",resourcename,fieldname,fieldValues));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldValues = fieldValues;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Object getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(Object fieldValues) {
		this.fieldValues = fieldValues;
	}	
	
}

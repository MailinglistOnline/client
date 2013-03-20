package com.redhat.mailinglistOnline.client.entities;


import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mongodb.BasicDBObject;


@ManagedBean
public class User extends BasicDBObject{

    
	private static final long serialVersionUID = -6858919384286693764L;

	
	private static final String ROOT_NAME_TAG = "name";
	private static final String ROOT_PASSWORD_TAG = "password";

	public String getName() {
		return getString(ROOT_NAME_TAG);
		
	}
	@NotNull
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Size(min = 1, max = 25)
	public void setName(String name) {
		put(ROOT_NAME_TAG, name);
	}

	public String getPassword() {
		return getString(ROOT_PASSWORD_TAG);
	}
	@NotNull
	public void setPassword(String password) {
		put(ROOT_PASSWORD_TAG, password);
	}
}

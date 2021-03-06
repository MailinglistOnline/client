package com.redhat.mailinglistOnline.client.entities;


import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.mongodb.BasicDBObject;

/**
 * Entity used to handle information about the logged user.
 * 
 * @author Matej Briškár
 */
@Named("user")
@SessionScoped
public class User extends BasicDBObject{

	private static final long serialVersionUID = -6858919384286693764L;
	public static final String ROOT_NAME_TAG = "username";
	public static final String ROOT_PASSWORD_TAG = "password";
	public static final String ROOT_ROLES_TAG = "roles";

	public String getName() {
		return getString(ROOT_NAME_TAG);
		
	}
	/*@NotNull
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Size(min = 5, max = 25)*/
	public void setName(String name) {
		put(ROOT_NAME_TAG, name);
	}

	public String getPassword() {
		return getString(ROOT_PASSWORD_TAG);
	}
	
	public void setPassword(String password) {
		put(ROOT_PASSWORD_TAG, password);
	}
	
	public List<String> getRoles() {
		return (List<String>) get(ROOT_ROLES_TAG);
	}

	public void setRoles(List<String> roles) {
		put(ROOT_ROLES_TAG, roles);
	}
}

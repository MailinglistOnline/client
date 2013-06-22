package com.redhat.mailinglistOnline.jsf;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import org.jboss.security.auth.spi.Util;

import com.redhat.mailinglistOnline.client.DbClient;
import com.redhat.mailinglistOnline.client.entities.User;
import com.redhat.mailinglistOnline.security.MongoDbLoginModule;

@ManagedBean(name = "reg")
@ViewScoped
public class RegisterUser {

	private String username;
	private String password;
	private String passwordAgain;

	@Inject
	DbClient dbClient;
	MongoDbLoginModule module;
	
	public RegisterUser() {
		module = new MongoDbLoginModule();
	}

	public String register() throws LoginException {
		if (password.equals(passwordAgain)) {
			if (dbClient.getUserByName(username) == null) {
				User user = new User();
				user.setName(username);
				String hashedPassword=Util.createPasswordHash("SHA-256", "BASE64",null, username, password, null);
				 
				user.setPassword(hashedPassword);
				List<String> roles = new ArrayList<String>();
				roles.add("user");
				user.setRoles(roles);
				dbClient.saveUser(user);
			}
		}
		return "home";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
}
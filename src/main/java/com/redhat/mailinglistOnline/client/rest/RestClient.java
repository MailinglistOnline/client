package com.redhat.mailinglistOnline.client.rest;


import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import com.redhat.mailinglistOnline.client.entities.Email;


@SessionScoped
@ManagedBean(name="client")
public class RestClient {
	
	List<Email> emails;
	String abc="abcabc";


	public void getAllEmails() {
			RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
			RestInterface client = ProxyFactory.create(RestInterface.class, "http://localhost:8080");
			emails= client.getAllEmails(); 
	}
	
	public String getAbc() {
		return abc;
	}
	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
}


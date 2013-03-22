package com.redhat.mailinglistOnline.client.rest;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


import com.redhat.mailinglistOnline.client.entities.Email;

@ManagedBean(name="response")
@ViewScoped
public class ServerResponse {

	@ManagedProperty(value="#{client}")
	RestClient client;
	
	
	public RestClient getClient() {
		return client;
	}

	public void setClient(RestClient client) {
		this.client = client;
	}



	private List<Email> emails;
	
	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}


	
	public void getAllEmails() {
		emails=client.getAllEmails();
	}

}

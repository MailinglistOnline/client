package com.redhat.mailinglistOnline.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="detailedEmail")
@RequestScoped
public class DetailedEmail {
	
	@ManagedProperty(value="#{client}")
	RestClient restClient;
	
	private Email email;
	
	public String setEmail(Email email) {
		this.email=email;
		return "/email/index.xhtml";
	}
	
	public String setEmail(String emailId) {
		email =restClient.getEmailById(emailId);
		return "/email/index.xhtml";
	}
	
	public Email getEmail() {
		return email;
	}
	
	public RestClient getRestClient() {
		return restClient;
	}
	
	public void setRestClient(RestClient restClient) {
		this.restClient=restClient;
	}
	

}

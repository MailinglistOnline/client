package com.redhat.mailinglistOnline.jsf;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;

@ManagedBean(name="contentResponse")
@ViewScoped
public class ContentEmailsResponse {

	@ManagedProperty(value="#{client}")
	RestClient client;

	private List<Email> emails;
	
	
	public RestClient getClient() {
		return client;
	}

	public void setClient(RestClient client) {
		this.client = client;
	}



	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}


	
	public void getAllEmails() {
		emails=client.getAllEmails();
	}
	
	public void getMailingListRoot(String mailingList) {
		emails=client.getMailingListRoot(mailingList);
	}

}

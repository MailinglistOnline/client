package com.redhat.mailinglistOnline.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="mailinglists")
@SessionScoped
public class MailingListsResponse {
	
	private List<String> mailingLists;

	@ManagedProperty(value="#{client}")
	RestClient client;
	
	public MailingListsResponse() {
		
	}
	
	public RestClient getClient() {
		return client;
	}

	public void setClient(RestClient client) {
		this.client = client;
	}


	public List<String> getMailingLists() {
		if(mailingLists == null) {
			mailingLists=client.getAllMailingLists();
		}
		return mailingLists;
	}

	public void setMailingLists(List<String> emails) {
		this.mailingLists = emails;
	}



}

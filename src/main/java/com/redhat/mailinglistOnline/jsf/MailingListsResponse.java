package com.redhat.mailinglistOnline.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="mailinglists")
@SessionScoped
public class MailingListsResponse {
	
	public static List<String> mailingLists;

	@ManagedProperty(value="#{client}")
	RestClient client;
	
	public MailingListsResponse() {
		
	}
	
	@PostConstruct
	public void init() {
		mailingLists=client.getAllMailingLists();
	}
	
	public RestClient getClient() {
		return client;
	}

	public void setClient(RestClient client) {
		this.client = client;
	}


	public List<String> getMailingLists() {
		return mailingLists;
	}

	public void setMailingLists(List<String> emails) {
		this.mailingLists = emails;
	}
	
	public boolean isMailingList(String list) {
		return mailingLists.contains(list);
	}



}

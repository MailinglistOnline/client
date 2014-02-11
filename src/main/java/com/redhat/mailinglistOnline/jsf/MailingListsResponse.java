package com.redhat.mailinglistOnline.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.redhat.mailinglistOnline.client.entities.Mailinglist;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="mailinglists")
@SessionScoped
public class MailingListsResponse {
	
	public static List<Mailinglist> mailingLists;

	@Inject
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


	public List<Mailinglist> getMailingLists() {
		return mailingLists;
	}

	public void setMailingLists(List<Mailinglist> emails) {
		this.mailingLists = emails;
	}
	
	public boolean isMailingList(String list) {
		return mailingLists.contains(list);
	}

	public Mailinglist getDefaultMailinglist() {
		return mailingLists.get(0);
	}
	

	



}

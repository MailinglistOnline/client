package com.redhat.mailinglistOnline.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;

@ManagedBean(name="contentResponse")
@ViewScoped
public class ContentEmailsResponse implements Serializable{

	@ManagedProperty(value="#{client}")
	RestClient client;

	private List<Email> emails;
	private String mailinglist;
	
	
	public String getMailinglist() {
		return mailinglist;
	}

	public void setMailinglist(String mailinglist) {
		this.mailinglist = mailinglist;
	}

	public RestClient getClient() {
		return client;
	}

	public void setClient(RestClient client) {
		this.client = client;
	}

	public void clear() {
		emails.clear();
	}


	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	
	public String selectedEmail(Email email) {
		return "index";
	}


	
	public void getAllEmails() {
		emails=client.getAllEmails();
	}
	
	public void getMailingListRoot() {
		if(mailinglist == null) {
			return;
		}
		emails=client.getMailingListRoot(mailinglist);
	}

}

package com.redhat.mailinglistOnline.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;
import com.redhat.mailinglistOnline.client.rest.RestClient;

/*
 * A response from the server containing the list of emails as the result for the given query (latest, search etc).
 */
@ManagedBean(name="contentResponse")
@ViewScoped
public class ContentEmailsResponse implements Serializable{

	@Inject
	RestClient client;

	private List<? extends MiniEmail> emails;
	private String viewMailinglist;
	
	
	public String getViewMailinglist() {
		return viewMailinglist;
	}

	public void setViewMailinglist(String mailinglist) {
		this.viewMailinglist = mailinglist;
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

	public List<? extends MiniEmail> getEmails() {
		return emails;
	}

	public void setEmails(List<MiniEmail> emails) {
		this.emails = emails;
	}
	
	public String selectedEmail(MiniEmail email) {
		return "index";
	}

	public void getAllEmails() {
		emails=client.getAllEmails();
	}
	
	public void getMailingListRoot() {
		if(viewMailinglist == null) {
			return;
		}
		emails=client.getMailingListRoot(viewMailinglist);
	}
	
	// said to be probably bug in JBOSS 7.1.1, when passing integer in EL, 
	//it says there is no method with long parameter. Can be deleted afterwards
	public void getLatest(Long number) {
		getLatest(number.intValue());
	}
	
	public void getLatest(Integer number) {
		if(viewMailinglist == null) {
			return;
		}
		emails=client.getMailinglistLatest(viewMailinglist, number);
		System.out.println();
	}
	
	public void searchEmailsByContent(String content) {
		this.emails=client.searchEmailsByContent(content);
	}
	
	

}

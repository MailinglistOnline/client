package com.redhat.mailinglistOnline.jsf;

import java.io.Serializable;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.inject.Inject;

import org.richfaces.event.ItemChangeEvent;
import org.richfaces.event.ItemChangeListener;

import com.redhat.mailinglistOnline.client.SelectedMailinglist;
import com.redhat.mailinglistOnline.client.responses.EmailsResponse;
import com.redhat.mailinglistOnline.client.rest.RestClient;


/*
 * Selection on the top from latest, search, roots of the selected mailinglist
 */
@ManagedBean(name="panelChangeListener")
@ViewScoped
public class PanelChangeListener implements ItemChangeListener, Serializable{
	
	private static int LATEST_EMAIL_COUNT = 10;
		
	@ManagedProperty(value="#{searchString}") 
	private String searchString;
	@ManagedProperty(value="#{fromString}") 
	private String fromString;
	@ManagedProperty(value="#{tagString}") 
	private String tagString;
	
	@Inject
	RestClient client;
	
	@Inject
	@SelectedMailinglist
	private String selectedMailinglist;
	
	

	@ManagedProperty(value="#{contentResponse}") 
	private EmailsResponse contentEmails;

	@Override
	public void processItemChange(ItemChangeEvent event)
			throws AbortProcessingException {
		if(event.getNewItemName().equals("latest") ) {
			client.getMailinglistLatest(selectedMailinglist,LATEST_EMAIL_COUNT);
		} else if (event.getNewItemName().equals("topics") ) {
			client.getMailingListRoot(selectedMailinglist);
		} 
	}


	public void search() {
		if(searchString != null) {
				client.searchEmailsByContent(searchString,contentEmails);
				contentEmails.filter(selectedMailinglist,fromString,Arrays.asList(tagString.split("\\s*,\\s*")));
		} else {
				client.getEmails(selectedMailinglist,fromString,Arrays.asList(tagString.split("\\s*,\\s*")));
		}
	}

	
	public EmailsResponse getContentEmails() {
		return contentEmails;
	}

	public void setContentEmails(EmailsResponse contentEmails) {
		this.contentEmails = contentEmails;
	}

	
	public String getSearchString() {
		return searchString;
	}
	
	public void setSearchString(String value) {
		searchString = value;
	}
	
	public String getFromString() {
		return fromString;
	}


	public void setFromString(String fromString) {
		this.fromString = fromString;
	}


	public String getTagString() {
		return tagString;
	}


	public void setTagString(String tagString) {
		this.tagString = tagString;
	}
	
}

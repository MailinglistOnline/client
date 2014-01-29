package com.redhat.mailinglistOnline.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;

import org.richfaces.event.ItemChangeEvent;
import org.richfaces.event.ItemChangeListener;


/*
 * Selection on the top from latest, search, roots of the selected mailinglist
 */
@ManagedBean(name="panelChangeListener")
@ViewScoped
public class PanelChangeListener implements ItemChangeListener, Serializable{
	
	private static int LATEST_EMAIL_COUNT = 10;
	
	@ManagedProperty(value="#{searchOption}") 
	private String searchOption;
	
	@ManagedProperty(value="#{searchString}") 
	private String searchString;

	
	@ManagedProperty(value="#{contentResponse}") 
	private ContentEmailsResponse contentEmails;

	@Override
	public void processItemChange(ItemChangeEvent event)
			throws AbortProcessingException {
		if(event.getNewItemName().equals("latest") ) {
			contentEmails.getLatest(LATEST_EMAIL_COUNT);
		} else if (event.getNewItemName().equals("topics") ) {
			contentEmails.getMailingListRoot();
		} 
	}


	public void search() {
		if ("content".equals(searchOption)) {
			contentEmails.searchEmailsByContent(searchString);
		}
	}
	public ContentEmailsResponse getContentEmails() {
		return contentEmails;
	}

	public void setContentEmails(ContentEmailsResponse contentEmails) {
		this.contentEmails = contentEmails;
	}

	public String getSearchOption() {
		return searchOption;
	}
	
	public void setSearchOption(String value) {
		searchOption = value;
	}
	
	public String getSearchString() {
		return searchString;
	}
	
	public void setSearchString(String value) {
		searchString = value;
	}
}

package com.redhat.mailinglistOnline.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;

import org.richfaces.event.ItemChangeEvent;
import org.richfaces.event.ItemChangeListener;

import com.redhat.mailinglistOnline.client.UserSession;

@ManagedBean(name="panelChangeListener")
@ViewScoped
public class PanelChangeListener implements ItemChangeListener{
	
	private static int LATEST_NUMBER = 10;

	
	@ManagedProperty(value="#{contentResponse}") 
	private ContentEmailsResponse contentEmails;

	@Override
	public void processItemChange(ItemChangeEvent event)
			throws AbortProcessingException {
		if(event.getNewItemName().equals("latest") ) {
			contentEmails.getLatest(LATEST_NUMBER);
		} else if (event.getNewItemName().equals("topics") ) {
			contentEmails.getMailingListRoot();
		} else if (event.getNewItemName().equals("search") ) {
			contentEmails.clear();
		}
		
	}


	public ContentEmailsResponse getContentEmails() {
		return contentEmails;
	}

	public void setContentEmails(ContentEmailsResponse contentEmails) {
		this.contentEmails = contentEmails;
	}


}

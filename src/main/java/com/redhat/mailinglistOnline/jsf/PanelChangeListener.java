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
	
	@ManagedProperty(value="#{userSession}") 
	private UserSession user;
	
	@ManagedProperty(value="#{contentResponse}") 
	private ContentEmailsResponse contentEmails;

	@Override
	public void processItemChange(ItemChangeEvent event)
			throws AbortProcessingException {
		if(event.getNewItemName().equals("all") ) {
			contentEmails.getAllEmails();
		} else if (event.getNewItemName().equals("topics") ) {
			contentEmails.getMailingListRoot();
		} else if (event.getNewItemName().equals("search") ) {
			contentEmails.clear();
		}
		
	}

	public UserSession getUser() {
		return user;
	}

	public void setUser(UserSession user) {
		this.user = user;
	}

	public ContentEmailsResponse getContentEmails() {
		return contentEmails;
	}

	public void setContentEmails(ContentEmailsResponse contentEmails) {
		this.contentEmails = contentEmails;
	}


}

package com.redhat.mailinglistOnline.client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.redhat.mailinglistOnline.client.entities.User;
import com.redhat.mailinglistOnline.jsf.ContentEmailsResponse;
import com.redhat.mailinglistOnline.jsf.MailingListsResponse;

@SessionScoped
@ManagedBean(name="userSession")
public class UserSession {
	
	@Inject
	private DbClient dbClient;
	@ManagedProperty(value="#{mailinglists}") 
	private MailingListsResponse mailinglistResponse;



	private String selectedMailingList="abc";
	
	
	public UserSession() {
	}
		
	public void setSelectedMailingList(String newMailingList) {
		if(mailinglistResponse.isMailingList(newMailingList)) {
			selectedMailingList=newMailingList;
		}
	}
	
	public String selectMailingList(String list) {
		selectedMailingList=list;
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String getSelectedMailingList() {
		return selectedMailingList;
	}
	
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	public MailingListsResponse getMailinglistResponse() {
		return mailinglistResponse;
	}

	public void setMailinglistResponse(MailingListsResponse mailinglistResponse) {
		this.mailinglistResponse = mailinglistResponse;
	}
	
}
	



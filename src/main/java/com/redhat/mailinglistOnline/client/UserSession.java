package com.redhat.mailinglistOnline.client;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
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




	
	
	public UserSession() {
	}
	
	@PostConstruct
	public void init() {
		//selectedMailingList=mailinglistResponse.getMailingLists().get(0);
	}
		
	/*public void setSelectedMailingList(String newMailingList) throws IOException {
		if(mailinglistResponse.isMailingList(newMailingList)) {
			selectedMailingList=newMailingList;
		} else {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/" + getSelectedMailingList());
		}
	}*/
	
	/*public String selectMailingList(String list) throws IOException {
		setSelectedMailingList(list);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String getSelectedMailingList() {
		return selectedMailingList;
	}*/
	
	
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
	



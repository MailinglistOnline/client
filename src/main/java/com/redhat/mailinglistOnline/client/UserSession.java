package com.redhat.mailinglistOnline.client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.redhat.mailinglistOnline.client.entities.User;
import com.redhat.mailinglistOnline.jsf.ContentEmailsResponse;

@SessionScoped
@ManagedBean(name="userSession")
public class UserSession {
	
	@Inject
	private DbClient dbClient;
	
	private String selectedMailingList="abc";
	
	
	public UserSession() {
	}
		
	public void setSelectedMailingList(String newMailingList) {
		selectedMailingList=newMailingList;
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
	
}
	



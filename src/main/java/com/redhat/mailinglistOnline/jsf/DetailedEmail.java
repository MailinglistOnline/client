package com.redhat.mailinglistOnline.jsf;

import java.io.IOException;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import com.redhat.mailinglistOnline.client.UserSession;
import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="detailedEmail")
@ViewScoped 
public class DetailedEmail {
	
	@ManagedProperty(value="#{client}")
	private RestClient restClient;
	
	@ManagedProperty(value="#{mailinglists}") 
	private MailingListsResponse mailinglistResponse;
	
	
	
	private String selectedId;
	private Email email;
	private List<Email> replies;
	
	private String selectedMailinglist;

	public String getSelectedMailinglist() {
		return selectedMailinglist;
	}

	public void setSelectedMailinglist(String selectedMailinglist) {
		this.selectedMailinglist = selectedMailinglist;
	}

	public void load() throws IOException {
		email= restClient.getEmailById(selectedId);
		//email.getMainContent().get(0).getContent().replaceAll("(\r\n|\n)", "<br />"));
		if(isInMailinglist(selectedMailinglist) && selectedMailinglist!=null) {
			replies = restClient.getEmailReplies(email);
		} else {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/" + mailinglistResponse.getDefaultMailinglist());
		}
	}
	
	/*public String setEmail(String emailId) {
		email =restClient.getEmailById(emailId);
		replies = restClient.getEmailReplies(email);
		return "/email/index.xhtml";
	}*/

	public MailingListsResponse getMailinglistResponse() {
		return mailinglistResponse;
	}

	public void setMailinglistResponse(MailingListsResponse mailinglistResponse) {
		this.mailinglistResponse = mailinglistResponse;
	}

	public Email getEmail() {
		return email;
	}
	
	public String getSelectedId() {
		return selectedId;
	}
	
	
	public void setSelectedId(String selectedId) {
		this.selectedId=selectedId;
	}
	public List<Email> getReplies() {
		return replies;
	}
	
	public void setReplies(List<Email> replies) {
		this.replies=replies;
	}
	
	public RestClient getRestClient() {
		return restClient;
	}
	
	public void setRestClient(RestClient restClient) {
		this.restClient=restClient;
	}
	
	public boolean isInMailinglist(String mailinglist) {
		return email.getMessageMailingLists().get(0).equals(mailinglist);
	}
	

}

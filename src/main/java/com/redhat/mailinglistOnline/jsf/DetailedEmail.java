package com.redhat.mailinglistOnline.jsf;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="detailedEmail")
@ViewScoped 
public class DetailedEmail {
	
	@ManagedProperty(value="#{client}")
	private RestClient restClient;
	
	private String selectedId;
	private Email email;
	private List<Email> replies;

	public void load() {
		email= restClient.getEmailById(selectedId);
		replies = restClient.getEmailReplies(email);
	}
	
	/*public String setEmail(String emailId) {
		email =restClient.getEmailById(emailId);
		replies = restClient.getEmailReplies(email);
		return "/email/index.xhtml";
	}*/
	
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
	

}

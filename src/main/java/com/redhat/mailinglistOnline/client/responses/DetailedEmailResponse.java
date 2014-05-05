package com.redhat.mailinglistOnline.client.responses;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.rest.RestClient;


/*
 * Emails response is not good enough, because we need to have methods like addTag etc.
 */
@Named("detailedEmailResponse")
@ViewScoped
public class DetailedEmailResponse implements Serializable {

	private static final long serialVersionUID = 8845358171252978617L;
	private String newTag;
	private Email email;
	
	@Inject
	RestClient client;

	public void addTag(){
		client.addTagToEmail(email.getId(), newTag);
	}

	public String getNewTag() {
		return newTag;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public RestClient getClient() {
		return client;
	}

	public void setClient(RestClient client) {
		this.client = client;
	}
	
	
	public void setNewTag(String newTag) {
		this.newTag = newTag;
	}
	
	public void removeTag(String tag){
		client.removeTagFromEmail(email.getId(), tag);;
	}

}
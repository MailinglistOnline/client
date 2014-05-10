package com.redhat.mailinglistOnline.jsf;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named("selectedMailinglist")
@ViewScoped
public class CurrentlySelectedMailinglist implements Serializable{

	private String mailinglist;

	public String getMailinglist() {
		return mailinglist;
	}

	public void setMailinglist(String mailinglist) {
		this.mailinglist = mailinglist;
	}
	
}

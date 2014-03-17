package com.redhat.mailinglistOnline.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("selectedMailinglist")
@RequestScoped
public class CurrentlySelectedMailinglist {

	private String mailinglist;

	public String getMailinglist() {
		return mailinglist;
	}

	public void setMailinglist(String mailinglist) {
		this.mailinglist = mailinglist;
	}
	
}

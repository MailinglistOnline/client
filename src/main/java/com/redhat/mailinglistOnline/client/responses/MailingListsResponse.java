package com.redhat.mailinglistOnline.client.responses;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.mailinglistOnline.client.entities.Mailinglist;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@Named("mailinglists")
@SessionScoped
public class MailingListsResponse {
	
	public static List<Mailinglist> mailingLists;
	public final static String ALL_MAILINGLISTS="all";
	
	@Inject
	RestClient client;
	
	//@PostConstruct Issue 19, sessions are constantly (about 4 per second) created when deployed to scaled app.
	public void init() {
		mailingLists=client.getAllMailingLists();
		Mailinglist allMailinglist = new Mailinglist();
		allMailinglist.setName(ALL_MAILINGLISTS);
		allMailinglist.setDescription("Mailinglist representing all the mailinglists");
		mailingLists.add(allMailinglist);
	}
	
	public List<Mailinglist> getMailingLists() {
		if(mailingLists == null) {
			init();
		}
		return mailingLists;
	}

	public void setMailingLists(List<Mailinglist> emails) {
		this.mailingLists = emails;
	}
	
	public boolean isMailingList(String list) {
		return mailingLists.contains(list);
	}

	public Mailinglist getDefaultMailinglist() {
		return mailingLists.get(0);
	}
	
}

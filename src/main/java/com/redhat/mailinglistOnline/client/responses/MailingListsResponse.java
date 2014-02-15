package com.redhat.mailinglistOnline.client.responses;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.redhat.mailinglistOnline.client.SelectedMailinglist;
import com.redhat.mailinglistOnline.client.entities.Mailinglist;
import com.redhat.mailinglistOnline.client.rest.RestClient;


@ManagedBean(name="mailinglists")
@SessionScoped
public class MailingListsResponse {
	
	public static List<Mailinglist> mailingLists;
	public final static String ALL_MAILINGLISTS="all";
	
	
	@Inject
	RestClient client;

	
	@PostConstruct
	public void init() {
		mailingLists=client.getAllMailingLists();
	}
	
	public List<Mailinglist> getMailingLists() {
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

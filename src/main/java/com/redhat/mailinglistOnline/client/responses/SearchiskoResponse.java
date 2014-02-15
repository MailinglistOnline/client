package com.redhat.mailinglistOnline.client.responses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.google.common.collect.Lists;
import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;



@Named("searchResponse")
@RequestScoped
public class SearchiskoResponse implements Serializable {

	private List<MiniEmail> emails;
	

	private String viewMailinglist;
	
    
	
	public void addEmails(List<MiniEmail> emails) {
		this.emails = emails;
	}

	public List<MiniEmail> getEmails() {
		return emails;
	}

	public void filter(String selectedMailinglist, String fromString,
			List<String> tags) {
		if ((tags != null && tags.size() == 1 && tags.get(0).equals(""))) {
			tags = null;
		}
		if (emails == null || emails.size() == 0) {
			return;
		}
		List<MiniEmail> filtered = Lists.newArrayList();
		for (MiniEmail e : emails) {
			if (selectedMailinglist == null
					|| selectedMailinglist
							.equals(MailingListsResponse.ALL_MAILINGLISTS)
					|| selectedMailinglist.equals(e.getMessageMailingList())) {
				if (fromString == null || fromString.equals("")
						|| fromString.equals(e.getFrom())) {
					if (tags == null || tags.size() == 0) {
						filtered.add(e);
					} else if (e.getTags() != null) {
						List<String> tagsMatch = new ArrayList<String>(tags);
						tagsMatch.retainAll(e.getTags());
						if (tagsMatch.size() > 0) {
							filtered.add(e);
						}
					}
				}
			}
		}
		emails = filtered;
	}

	public String getViewMailinglist() {
		return viewMailinglist;
	}

	public void setViewMailinglist(String mlist) {
		this.viewMailinglist = mlist;
	}

}
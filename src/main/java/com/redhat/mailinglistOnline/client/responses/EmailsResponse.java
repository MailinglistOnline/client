package com.redhat.mailinglistOnline.client.responses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.google.common.collect.Lists;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;
import com.redhat.mailinglistOnline.client.rest.RestClient;

/*
 * A response from the server containing the list of emails as the result for the given query (latest, search etc).
 */
@ManagedBean(name = "contentResponse")
@ViewScoped
public class EmailsResponse implements Serializable {

	private List<? extends MiniEmail> emails;
	private String viewMailinglist;

	public void addEmails(List<? extends MiniEmail> emails) {
		this.emails = emails;
	}

	public List<? extends MiniEmail> getEmails() {
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

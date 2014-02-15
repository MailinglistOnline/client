package com.redhat.mailinglistOnline.jsf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.AbortProcessingException;
import javax.inject.Inject;
import javax.inject.Named;

import org.richfaces.event.ItemChangeEvent;
import org.richfaces.event.ItemChangeListener;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;
import com.redhat.mailinglistOnline.client.responses.EmailsResponse;
import com.redhat.mailinglistOnline.client.responses.ResponseLoader;
import com.redhat.mailinglistOnline.client.rest.RestClient;

/*
 * Selection on the top from latest, search, roots of the selected mailinglist
 */
@Named("panelChangeListener")
@RequestScoped
public class PanelChangeListener implements ItemChangeListener, Serializable {

	private static int LATEST_EMAIL_COUNT = 10;

	@ManagedProperty(value = "#{searchString}")
	private String searchString;
	@ManagedProperty(value = "#{fromString}")
	private String fromString;
	@ManagedProperty(value = "#{tagString}")
	private String tagString;

	@Inject
	RestClient client;

	@Inject
	ResponseLoader loader;

	@Inject
	private EmailsResponse contentEmails;

	@Override
	public void processItemChange(ItemChangeEvent event)
			throws AbortProcessingException {
		if (event.getNewItemName().equals("latest")) {
			loader.getMailinglistLatest(contentEmails.getViewMailinglist(), LATEST_EMAIL_COUNT);
			/*List<Email> miniEmails = (List<Email>)contentEmails.getEmails();
			List<MiniEmail> replies = miniEmails.get(1).getReplies();
			System.out.println(); only for debug purposes*/
		} else if (event.getNewItemName().equals("topics")) {
			loader.getMailingListRoot(contentEmails.getViewMailinglist());
		}
	}

	public void search() {
		loader.searchEmailsByContent(searchString, contentEmails.getViewMailinglist(),
				fromString, Arrays.asList(tagString.split("\\s*,\\s*")));

	}

	
	public EmailsResponse getContentEmails() {
		return contentEmails;
	}

	public void setContentEmails(EmailsResponse contentEmails) {
		this.contentEmails = contentEmails;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String value) {
		searchString = value;
	}

	public String getFromString() {
		return fromString;
	}

	public void setFromString(String fromString) {
		this.fromString = fromString;
	}

	public String getTagString() {
		return tagString;
	}

	public void setTagString(String tagString) {
		this.tagString = tagString;
	}

}

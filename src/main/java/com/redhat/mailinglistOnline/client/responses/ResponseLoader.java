package com.redhat.mailinglistOnline.client.responses;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;
import com.redhat.mailinglistOnline.client.rest.RestClient;


/**
 * Object responsible to load the response from the server. The responses are {@link EmailsResponse}, {@link DetailedEmailResponse}, {@link SearchiskoResponse}.
 * Class is needed as there is no other way to load the response (other options are passing the object directly from restClient or having a logic in entities..).
 * 
 * @author Matej Briškár
 */
@RequestScoped
@Named("loader")
public class ResponseLoader {

	@Inject
	EmailsResponse response;
	
	@Inject
	DetailedEmailResponse detailedResponse;
	
	@Inject
	SearchiskoResponse searchResponse;
	
	@Inject 
	RestClient client;
	
	public void searchEmailsByContent(String searchString,String selectedMailinglist,
			String fromString, List<String> tags) {
		if(searchString != null && !searchString.equals("")) {
			List<MiniEmail> miniEmails=client.searchEmailsByContent(searchString);
			searchResponse.addEmails(miniEmails);
			searchResponse.filter(selectedMailinglist, fromString, tags);
		} else {
			return;
		}
		
	}

	public void getMailinglistLatest(String selectedMailinglist,
			int number) {
		if((selectedMailinglist == null) || (selectedMailinglist.equals(""))) {
			return;
		}
		List<Email> emails=client.getMailinglistLatest(selectedMailinglist, number);
		response.addEmails(emails);
	}

	public void getMailingListRoot(String selectedMailinglist) {
		List<Email> emails=client.getMailingListRoot(selectedMailinglist);
		response.addEmails(emails);
	}
	
	public void getMailingListRoot(String selectedMailinglist, int from, int to) {
		List<Email> emails=client.getMailingListRoot(selectedMailinglist, from,  to);
		response.addEmails(emails);
	}
	
	public void getDetailedMessage(String id){
		Email email =client.getEmailById(id);
		detailedResponse.setEmail(email);
	}
	
}

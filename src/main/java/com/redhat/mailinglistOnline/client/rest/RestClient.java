package com.redhat.mailinglistOnline.client.rest;


import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.redhat.mailinglistOnline.client.DbClient;
import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.entities.Mailinglist;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;
import com.redhat.mailinglistOnline.client.responses.EmailsResponse;

@Stateless(name="client")
public class RestClient {
	
	private static String SERVER_PROPERTIES_FILE_NAME = "server.properties";
	private String serverUrl;
	RestEmailInterface emailClient;
	RestMailingListInterface mailingListsClient;
	
	@Inject 
	EmailsResponse response;


	public RestClient() throws IOException {
		Properties prop = new Properties();
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        prop.load(DbClient.class.getClassLoader().getResourceAsStream((SERVER_PROPERTIES_FILE_NAME)));
        serverUrl = prop.getProperty("serverUrl");
        emailClient = ProxyFactory.create(RestEmailInterface.class, serverUrl);
        mailingListsClient = ProxyFactory.create(RestMailingListInterface.class, serverUrl);
	}
	
	public EmailsResponse getAllEmails() {
		
		response.addEmails(emailClient.getAllEmails());
		return response;
	}
	
	public Email getEmailById(String id) {
		return emailClient.getEmailById(id); 
	}
	
	public List<Mailinglist> getAllMailingLists() {
			return mailingListsClient.getAllMailingLists();
	}

	public List<Email> getMailingListRoot(String mailingList) {
		return emailClient.getMailingListRoots(mailingList);
	}
	
	public List<Email> getEmailReplies(MiniEmail email) {
		return emailClient.getEmailReplies(email.getId());
	}

	public void addTagToEmail(String id, String tag) {
		emailClient.addTag(id, tag);
		
	}
	
	public List<Email> getMailinglistLatest(String mailinglist, int number) {
		return emailClient.getMailinglistLatest(mailinglist,number);
	}
	
	public List<MiniEmail> searchEmailsByContent(String content) {
		List<MiniEmail> emails = emailClient.searchEmailByContent(content);
		return emails;
	
	}

	// this method should be after some time always used instead of getEmailById etc...
	public List<Email> getEmails(String selectedMailinglist, String fromString,
			List<String> tagString) {
		return emailClient.getEmails(selectedMailinglist,fromString,tagString);
	}


}


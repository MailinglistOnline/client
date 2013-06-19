package com.redhat.mailinglistOnline.client.rest;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.redhat.mailinglistOnline.client.DbClient;
import com.redhat.mailinglistOnline.client.entities.Email;

@ManagedBean(name="client")
@ApplicationScoped
public class RestClient {
	
	private static String SERVER_PROPERTIES_FILE_NAME = "server.properties";
	private String serverUrl;
	RestEmailInterface emailClient;
	RestMailingListInterface mailingListsClient;


	public RestClient() throws IOException {
		Properties prop = new Properties();
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        prop.load(DbClient.class.getClassLoader().getResourceAsStream((SERVER_PROPERTIES_FILE_NAME)));
        serverUrl = prop.getProperty("serverUrl");
        emailClient = ProxyFactory.create(RestEmailInterface.class, serverUrl);
        mailingListsClient = ProxyFactory.create(RestMailingListInterface.class, serverUrl);
        
	}
	
	public List<Email> getAllEmails() {
			return emailClient.getAllEmails(); 
	}
	
	public Email getEmailById(String id) {
		return emailClient.getEmailById(id); 
	}
	
	public List<String> getAllMailingLists() {
			MailingListWrapper wrapper= mailingListsClient.getAllMailingLists();
			return wrapper.getMailinglists();
	}

	public List<Email> getMailingListRoot(String mailingList) {
		return emailClient.getMailingListRoots(mailingList);
	}
	
	public List<Email> getEmailReplies(Email email) {
		return emailClient.getEmailReplies(email.getId());
	}

	public void addTagToEmail(String id, String tag) {
		emailClient.addTag(id, tag);
		
	}
	
	public List<Email> getMailinglistLatest(String mailinglist, int number) {
		return emailClient.getMailinglistLatest(mailinglist,number);
	}

}


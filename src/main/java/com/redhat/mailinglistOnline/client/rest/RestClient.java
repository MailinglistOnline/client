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


	public RestClient() throws IOException {
		Properties prop = new Properties();
        prop.load(DbClient.class.getClassLoader().getResourceAsStream((SERVER_PROPERTIES_FILE_NAME)));
        serverUrl = prop.getProperty("serverUrl");
        
	}
	
	public List<Email> getAllEmails() {
			RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
			RestInterface client = ProxyFactory.create(RestInterface.class, serverUrl);
			return client.getAllEmails(); 
	}

}


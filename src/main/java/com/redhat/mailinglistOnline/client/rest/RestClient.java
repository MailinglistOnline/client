package com.redhat.mailinglistOnline.client.rest;


import java.util.List;

import javax.ejb.Stateless;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import com.redhat.mailinglistOnline.client.entities.Email;


@Stateless(name="restClient")
public class RestClient {

	public List<Email> getAllEmails() {
			RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
			RestInterface client = ProxyFactory.create(RestInterface.class, "http://localhost:8080");
            return client.getAllEmails(); 
	}
}


package com.redhat.mailinglistOnline.security;

import java.security.acl.Group;
import java.util.Map;

import javax.inject.Inject;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import org.jboss.resteasy.plugins.server.embedded.SimplePrincipal;
import org.jboss.security.SimpleGroup;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

import com.redhat.mailinglistOnline.client.DbClient;
//https://access.redhat.com/knowledge/docs/en-US/JBoss_Enterprise_Application_Platform/5/html/Security_Guide/sect-Custom_LoginModule_Example.html
//http://java.dzone.com/articles/creating-custom-login-modules
import com.redhat.mailinglistOnline.client.entities.User;

public class MongoDbLoginModule extends UsernamePasswordLoginModule{

	
	@Inject DbClient dbClient;
	
	@Override
	 public void initialize(Subject subject, CallbackHandler callbackHandler,
             Map sharedState, Map options)
	{
		super.initialize(subject, callbackHandler, sharedState, options);

	}

	@Override
	protected String getUsersPassword() throws LoginException {
		return dbClient.getUserByName(getUsername()).getPassword();
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		SimpleGroup group = new SimpleGroup("Roles");
        try {
        	User user=dbClient.getUserByName(getUsername());
        	for (String role:user.getRoles()) {
        		group.addMember(new SimplePrincipal(role));
        	}
        } catch (Exception e) {
            throw new LoginException("Failed to create group member for " + group);
        }
        return new Group[] { group };
	}
	
	 //validatePassword(String inputPassword, String expectedPassword) for hash

}

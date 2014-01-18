package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

@Path("/mailinglists")
public interface RestMailingListInterface {
		@GET
	    @Path("/all")
	    @Produces("application/xml")
	    @Wrapped(element="mailinglists")
	    public MailingListWrapper getAllMailingLists();
}

 

package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import com.redhat.mailinglistOnline.client.entities.Mailinglist;

@Path("/mailinglists")
public interface RestMailingListInterface {
		@GET
	    @Path("/all")
	    @Produces("application/json")
	    //@Wrapped(element="mailinglists")
	    public List<Mailinglist> getAllMailingLists();
}

 

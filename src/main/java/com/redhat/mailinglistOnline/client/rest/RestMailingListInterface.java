package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import com.redhat.mailinglistOnline.client.entities.Mailinglist;

/**
 * A rest interface to communicate with the server component about the processed mailinglists.
 * 
 * @author Matej Briškár
 */
@Path("/mailinglists")
public interface RestMailingListInterface {
		@GET
	    @Path("/all")
	    @Produces("application/json")
	    public List<Mailinglist> getAllMailingLists();
}

 

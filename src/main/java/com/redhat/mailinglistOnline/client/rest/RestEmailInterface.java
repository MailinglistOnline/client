package com.redhat.mailinglistOnline.client.rest;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import com.redhat.mailinglistOnline.client.entities.Email;

@Path("/emails")
public interface RestEmailInterface {


	@GET
    @Path("/all")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getAllEmails();
    
    @GET
    @Path("/email/id")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public Email getEmailById(@QueryParam("id") String id);
    
    @GET
    @Path("/replies/id")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getEmailReplies(@QueryParam("id") String id);
    
    @GET
    @Path("/from")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getEmailByAuthor(@QueryParam("from") String author);

    @GET
    @Path("/mailinglist/roots/all")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getMailingListRoots(@QueryParam("mailinglist") String mailinglist);
    
    @GET
    @Path("/mailinglist/roots/")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getMailingListRoots(@QueryParam("from") int fromNumber,@QueryParam("to") int toNumber,@QueryParam("mailinglist") String mailinglist);
    
    
    @GET
    @Path("/thread/")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getEmailPath(@QueryParam("id") String id);
    
    @GET
    @Path("/mailinglist/latest/")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> getMailinglistLatest(@QueryParam("mailinglist") String mailinglist, @QueryParam("number") int number);
    
    
    
    /* SEARCH */
    @GET
    @Path("/search/")
    @Produces("application/xml")
    @Wrapped(element="emails")
    public List<Email> searchEmailByText(@QueryParam("text") String text);
 

    /* DATA MANIPULATION */
	@POST
    @Path("/email/tag/")
    public void addTag(@QueryParam("id") String id,@QueryParam("tag") String tag);

	
    
    


}

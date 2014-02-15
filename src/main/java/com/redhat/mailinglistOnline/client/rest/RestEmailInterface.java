package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
//import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;



import com.redhat.mailinglistOnline.client.entities.Email;
import com.redhat.mailinglistOnline.client.entities.MiniEmail;

@Path("/emails")
public interface RestEmailInterface {


	@GET
    @Path("/all")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getAllEmails();
    
    @GET
    @Path("/email/id")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public Email getEmailById(@QueryParam("id") String id);
    
    @GET
    @Path("/replies/id")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getEmailReplies(@QueryParam("id") String id);
    
    @GET
    @Path("/from")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getEmailByAuthor(@QueryParam("from") String author);

    @GET
    @Path("/mailinglist/roots/all")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getMailingListRoots(@QueryParam("mailinglist") String mailinglist);
    
    @GET
    @Path("/mailinglist/roots/")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getMailingListRoots(@QueryParam("from") int fromNumber,@QueryParam("to") int toNumber,@QueryParam("mailinglist") String mailinglist);
    
    
    @GET
    @Path("/thread/")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getEmailPath(@QueryParam("id") String id);
    
    @GET
    @Path("/mailinglist/latest/")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<Email> getMailinglistLatest(@QueryParam("mailinglist") String mailinglist, @QueryParam("number") int number);
    
    @GET
    @Path("/email/")
    @Produces("application/json")
	public List<Email> getEmails(@QueryParam("mailinglist") String mailinglist, @QueryParam("from") String from,
			@QueryParam("tag") List<String> tag);
    
    
    /* SEARCH */
    @GET
    @Path("/search/content")
    @Produces("application/json")
    //@Wrapped(element="emails")
    public List<MiniEmail> searchEmailByContent(@QueryParam("content") String content);
 

    /* DATA MANIPULATION */
	@POST
    @Path("/email/tag/")
    public void addTag(@QueryParam("id") String id,@QueryParam("tag") String tag);

	

	
    
    


}

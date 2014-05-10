package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public List<Email> getAllEmails();

	@GET
	@Path("/email/{id}")
	@Produces("application/json")
	public Email getEmailById(@PathParam("id") String id);

	@GET
	@Path("")
	@Produces("application/json")
	public List<Email> getEmails(
			@QueryParam("from") String author,
			@QueryParam("mailinglist") String mailinglist,
			@QueryParam("tags") List<String> tags,
			@QueryParam("count") int count,
			@QueryParam("descending") List<String> descending,
			@QueryParam("ascending") List<String> ascending);

	@GET
	@Path("")
	@Produces("application/json")
	public List<Email> getEmailByAuthor(@QueryParam("from") String author);

	@GET
	@Path("/{mailinglist}/roots/all")
	@Produces("application/json")
	// @Wrapped(element="emails")
	public List<Email> getMailingListRoots(
			@PathParam("mailinglist") String mailinglist);

	@GET
	@Path("/{mailinglist}/roots/")
	@Produces("application/json")
	public List<Email> getMailingListRoots(@QueryParam("from") int fromNumber,
			@QueryParam("to") int toNumber,
			@PathParam("mailinglist") String mailinglist);
	
	@GET
	@Path("/{mailinglist}/roots/count")
	@Produces("application/json")
	public Integer getMailingListRootCount(@PathParam("mailinglist") String mailinglist);

	@GET
	@Path("/thread/")
	@Produces("application/json")
	public List<Email> getEmailPath(@QueryParam("id") String id);

	// should be deleted after merge to only one method

	/*
	 * @GET
	 * 
	 * @Path("/email/")
	 * 
	 * @Produces("application/json") public List<Email>
	 * getEmails(@QueryParam("mailinglist") String mailinglist,
	 * 
	 * @QueryParam("from") String from,
	 * 
	 * @QueryParam("tag") List<String> tag);
	 */

	/* SEARCH */
	@GET
	@Path("/search/content")
	@Produces("application/json")
	// @Wrapped(element="emails")
	public List<MiniEmail> searchEmailByContent(
			@QueryParam("content") String content);

	/* DATA MANIPULATION */
	@POST
	@Path("/email/tag/")
	public void addTag(@QueryParam("id") String id,
			@QueryParam("tag") String tag);

	@DELETE
	@Path("/email/tag/")
	public void removeTag(@QueryParam("id") String id,
			@QueryParam("tag") String tag);

	
}

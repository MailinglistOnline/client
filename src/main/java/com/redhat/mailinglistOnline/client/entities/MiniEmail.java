package com.redhat.mailinglistOnline.client.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

public class MiniEmail implements Serializable {

	private static final long serialVersionUID = 9069501944384263364L;
	public static final String ID_MONGO_TAG = "_id";
	public static final String MAILINGLIST_MONGO_TAG = "mailinglist";
	public static final String MESSAGE_ID_MONGO_TAG = "message_id";
	public static final String SUBJECT_MONGO_TAG = "subject";
	public static final String DATE_MONGO_TAG = "date";
	public static final String FROM_MONGO_TAG = "from";
	// message snippet is the first x letters from the email
	public static final String MESSAGE_SNIPPET_MONGO_TAG = "message_snippet";
	public static final String TAGS_MONGO_TAG = "tags";
	private static final String HIGHLIGHTED_MAIN_CONTENT = "highlighted_main_content";
	
	@JsonProperty(ID_MONGO_TAG)
	private String id;
	private String messageId;
	private String subject;
	private long date;
	private String from;
	private String mailinglist;
	private List<String> tags = new ArrayList<String>();
	private String messageSnippet;
	private List<String> highlightedTexts;

	public MiniEmail() {
		super();
	}

	/*
	 * Needed when adding miniemail to mongodb
	 */
	public MiniEmail(MiniEmail email) {
		setId(email.getId());
		setMailinglist(email.getMailinglist());
		setMessageId(email.getMessageId());
		setSubject(email.getSubject());
		setDate(email.getDate());
		setFrom(email.getFrom());
		setMessageSnippet(email.getMessageSnippet());
		setTags(email.getTags());
	}

	@JsonProperty(HIGHLIGHTED_MAIN_CONTENT)
	public List<String> getHighlightedTexts() {
		return highlightedTexts;
	}

	public void setHighlightedTexts(List<String> texts) {
		highlightedTexts = texts;
	}

	public void addHighLight(String highLight) {
		highlightedTexts.add(highLight);
	}

	/*
	 * TODO: Waiting to know how to make it work.. Jackson issue.
	 */
	@JsonProperty(ID_MONGO_TAG)
	public String getId() {
		return id;
	}

	@JsonProperty(ID_MONGO_TAG)
	public void setId(String id) {
		this.id = id;

	}
	
	@JsonProperty(MAILINGLIST_MONGO_TAG)
	public void setMailinglist(String mailinglist) {
		this.mailinglist = mailinglist;
	}

	@JsonProperty(MESSAGE_ID_MONGO_TAG)
	public String getMessageId() {
		return messageId;
	}

	@JsonProperty(MESSAGE_ID_MONGO_TAG)
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@JsonProperty(MESSAGE_SNIPPET_MONGO_TAG)
	public String getMessageSnippet() {
		return messageSnippet;
	}

	@JsonProperty(MESSAGE_SNIPPET_MONGO_TAG)
	public void setMessageSnippet(String messageSnippet) {
		this.messageSnippet = messageSnippet;
	}

	@JsonProperty(SUBJECT_MONGO_TAG)
	public String getSubject() {
		return subject;
	}

	@JsonProperty(SUBJECT_MONGO_TAG)
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@JsonProperty(DATE_MONGO_TAG)
	public long getDate() {
		return date;
	}
	@JsonProperty(DATE_MONGO_TAG)
	public void setDate(long sentDate) {
		this.date = sentDate;
	}

	@JsonProperty(MAILINGLIST_MONGO_TAG)
	public String getMailinglist() {
		return mailinglist;
	}

	@JsonProperty(FROM_MONGO_TAG)
	public String getFrom() {
		return from;
	}

	@JsonProperty(FROM_MONGO_TAG)
	public void setFrom(String from) {
		this.from = from;
	}

	@JsonProperty(TAGS_MONGO_TAG)
	public List<String> getTags() {
		return tags;
	}

	@JsonProperty(TAGS_MONGO_TAG)
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void addTag(String tag) {
		if (tags.isEmpty()) {
			tags = new ArrayList<String>();
		}
		tags.add(tag);
	}
}

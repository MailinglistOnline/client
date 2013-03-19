package com.redhat.mailinglistOnline.client.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


	public class Email{
		
		private String id;
		private String root;
		private String inReplyTo;
		private ArrayList<String> replies;
		private String messageId;
		private String subject;
		private Date sentDate;
		private ArrayList<String> mailingLists;
		private String from;
		private ContentPart mainContent;
		private ArrayList<ContentPart> attachments;
	    
	    
	    
	    public Email() {
	        super();
	    }
	    
	    @XmlElement(name="id")
	    public String getId() {
	        return id;
	        
	    }
	    @XmlElement(name="root")
	    public String getRoot() {
	        return root;
	    }

	    @XmlElement(name="in_reply_to")
	    public String getInReplyTo() {
	        return inReplyTo;
	    }
	    
	    @XmlElementWrapper(name="replies")
	    @XmlElement(name="reply")
	     public List<String> getReplies() {
	       return replies;
	    }

	    @XmlElement(name="message_id")
	    public String getMessageId() {
	        return messageId;
	    }

	    @XmlElement(name="subject")
	    public String getSubject() {
	        return subject;
	    }

	    @XmlElement(name="sent_date")
	    public Date getSentDate() {
	        return sentDate;
	    }

	    
	    @XmlElementWrapper(name="mailing_lists")
	    @XmlElement(name="mailing_list")
	    public ArrayList<String> getMessageMailingLists() {
	       return mailingLists;
	       
	    }
	    @XmlElement(name="from")
	    public String getFrom() {
	        return from;
	    }

	    @XmlElement(name="main_content")
	    public ContentPart getMainContent() {
	        return mainContent;
	    }
	    
	    @XmlElementWrapper(name="attachments")
	    @XmlElement(name="attachment")
	    public ArrayList<ContentPart> getAttachments() {
	        return attachments;
	    }


	}


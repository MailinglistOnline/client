package com.redhat.mailinglistOnline.client.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "email")
	public class Email implements Serializable{
		
		private String id;
		private String root;
		private String inReplyTo;
		private List<String> replies= new ArrayList<String>();
		private String messageId;
		private String mainContentHtml;
		private String subject;
		private Date sentDate;
		private List<String> messageMailingLists=new ArrayList<String>();
		private String from;
		private List<ContentPart> mainContent=new ArrayList<ContentPart>();
		private List<ContentPart> attachments =new ArrayList<ContentPart>();
		private List<String> tags=new ArrayList<String>();
	    
	    

		public void setId(String id) {
			this.id = id;
		}

		public void setRoot(String root) {
			this.root = root;
		}

		public void setInReplyTo(String inReplyTo) {
			this.inReplyTo = inReplyTo;
		}

		public void setReplies(ArrayList<String> replies) {
			this.replies = replies;
		}

		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public void setSentDate(Date sentDate) {
			this.sentDate = sentDate;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public void setMainContent(ArrayList<ContentPart> mainContent) {
			this.mainContent = mainContent;
		}

		public void setAttachments(ArrayList<ContentPart> attachments) {
			this.attachments = attachments;
		}
		
		 public void setTags(ArrayList<String> tags) {
		        this.tags=tags;
		    }


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
	    public List<String> getMessageMailingLists() {
	       return messageMailingLists;
	       
	    }
	    @XmlElement(name="from")
	    public String getFrom() {
	        return from;
	    }

	    @XmlElementWrapper(name="main_content")
	    @XmlElement(name="alternative")
	    public List<ContentPart> getMainContent() {
	        return mainContent;
	    }
	    
	    @XmlElementWrapper(name="attachments")
	    @XmlElement(name="attachment")
	    public List<ContentPart> getAttachments() {
	        return attachments;
	    }
	    
	    @XmlElement(name="tags")
	    public List<String> getTags() {
	        return tags;
	    }
	    
	    
	    public String getDateInString() {
	    	return new SimpleDateFormat("yyyy-MM-dd").format(sentDate);
	    }
	    

	   

	}


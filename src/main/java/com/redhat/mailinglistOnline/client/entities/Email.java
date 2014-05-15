package com.redhat.mailinglistOnline.client.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The main entity used to store the emails.
 * 
 * @author Matej Briškár
 */
@XmlRootElement(name = "email")
public class Email extends MiniEmail{

	private static final long serialVersionUID = 9122202937488854481L;
	public static final String ROOT_MONGO_TAG = "thread_root";
    public static final String IN_REPLY_TO_MONGO_TAG = "in_reply_to";
    public static final String REPLIES_MONGO_TAG = "replies";
    public static final String ATTACHMENTS_MONGO_TAG = "attachments";
    public static final String MAIN_CONTENT_MONGO_TAG = "main_content";
    public static final String SHARD_KEY_MONGO_TAG = "email_shard_key";
    
    private MiniEmail root;
    private MiniEmail inReplyTo;
    private List<MiniEmail> replies= new ArrayList<MiniEmail>();
    private List<ContentPart> mainContent=new ArrayList<ContentPart>();
    private List<ContentPart> attachments =new ArrayList<ContentPart>();
    private String shardKey;
    
    public Email() {
        super();
    }
    
    @JsonProperty(ROOT_MONGO_TAG)
    public MiniEmail getRoot() {
        return root;
    }

    @JsonProperty(ROOT_MONGO_TAG)
    public void setRoot(MiniEmail root) {
        this.root=root;
    }


    @JsonProperty(IN_REPLY_TO_MONGO_TAG)
    public MiniEmail getInReplyTo() {
        return inReplyTo;
    }
    
    @JsonProperty(IN_REPLY_TO_MONGO_TAG)
    public void setInReplyTo(MiniEmail inReplyTo) {
        this.inReplyTo=inReplyTo;
    }

    
    @JsonProperty(REPLIES_MONGO_TAG)
    public void setReplies(List<MiniEmail> replies) {
    	this.replies=replies;
    }

    public void addReply(MiniEmail reply) {
        if(replies == null) {
        	replies = new ArrayList<MiniEmail>();
        }
        replies.add(new MiniEmail(reply));
    }
    
    @JsonProperty(REPLIES_MONGO_TAG)
    public List<MiniEmail> getReplies() {
       return replies;
    }

    public void addAttachment(ContentPart part) {
        if(attachments == null) {
        	attachments =new ArrayList<ContentPart>();
        }
        attachments.add(part);
    }
    
    @JsonProperty(ATTACHMENTS_MONGO_TAG)
    public void setAttachments(List<ContentPart> attachments) {
    	this.attachments=attachments;
    }

    @JsonProperty(MAIN_CONTENT_MONGO_TAG)
    public List<ContentPart> getMainContent() {
        return mainContent;
    }

    @JsonProperty(MAIN_CONTENT_MONGO_TAG)
    public void setMainContent(List<ContentPart> mainContent) {
         this.mainContent=mainContent;
    }
    
    @JsonProperty(ATTACHMENTS_MONGO_TAG)
    public List<ContentPart> getAttachments() {
        return attachments;
    }
    
    public String getDateInString() {
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	return df.format(new Date(getDate()));
    }
    
    @JsonProperty(SHARD_KEY_MONGO_TAG)
    public String getShardKey() {
        return shardKey;
    }

    @JsonProperty(SHARD_KEY_MONGO_TAG)
    public void setShardKey(String key) {
        this.shardKey=key;
    }
    
}



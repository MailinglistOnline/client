package com.redhat.mailinglistOnline.client.entities;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Entity used to save information about the content,attachments(files, signature etc.) of the email.
 * 
 * @author Matej Briškár
 */
@XmlRootElement(name = "ContentPart")
public class ContentPart{

	private static final long serialVersionUID = 7103483924512914564L;
	private String type;
    private String content;
    private String link;

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }
    @JsonProperty("type")
    public void setType(String type) {
        this.type=type;
    }
    @JsonProperty("text")
    public String getContent() {
        return content;
    }
    @JsonProperty("text")
    public void setContent(String content) {
        this.content=content;
    }
    @JsonProperty("link")
    public String getLink() {
        return link;
    }
    @JsonProperty("link")
    public void setLink(String link) {
    	this.link=link;
    }
    
    
}
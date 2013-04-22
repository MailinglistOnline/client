package com.redhat.mailinglistOnline.client.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ContentPart")
public class ContentPart{
	
	private String type;
	private String content;


    @XmlElement
    public String getType() {
        return type;
    }
    
    public String getShorterContent(int length) {
    	if(content.length()< length) {
    		length=content.length();
    	}
    	return content.substring(0,length);
    }


    public void setType(String type) {
		this.type = type;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@XmlElement
    public String getContent() {
        return content;
    }


    
}
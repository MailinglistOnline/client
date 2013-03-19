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


    @XmlElement
    public String getContent() {
        return content;
    }


    
}
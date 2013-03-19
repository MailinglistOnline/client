package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.redhat.mailinglistOnline.client.entities.Email;



@XmlRootElement(name = "collection")
public class RestEmailCollection {

	  @XmlElement(name="email")
	  public List<Email> emails;
	
}

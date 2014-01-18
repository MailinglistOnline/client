package com.redhat.mailinglistOnline.client.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mailinglists")
public class MailingListWrapper {
   
   private List<String> mailinglists;

   @XmlElement(name="mailing_list")
   public List<String> getMailinglists() {
       return mailinglists;
   }

   public void setMailinglists(List<String> mailinglists) {
       this.mailinglists = mailinglists;
   }
   
   
   
}


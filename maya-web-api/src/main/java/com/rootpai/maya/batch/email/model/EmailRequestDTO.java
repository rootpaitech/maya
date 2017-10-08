/**
 * 
 */
package com.rootpai.maya.batch.email.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author agara
 *
 */
public class EmailRequestDTO {

  private List<String> senderEmails;

  private String emailSubject;

  /**
   * 
   */
  public EmailRequestDTO() {

    senderEmails = new ArrayList<>();
  }

  public void addSenderEmail(String senderEmail) {

    this.senderEmails.add(senderEmail);
  }

  /**
   * @return the senderEmails
   */
  public List<String> getSenderEmails() {

    return senderEmails;
  }

  /**
   * @param senderEmails the senderEmails to set
   */
  public void setSenderEmails(List<String> senderEmails) {

    this.senderEmails = senderEmails;
  }

  /**
   * @return the emailSubject
   */
  public String getEmailSubject() {

    return emailSubject;
  }

  /**
   * @param emailSubject the emailSubject to set
   */
  public void setEmailSubject(String emailSubject) {

    this.emailSubject = emailSubject;
  }
}
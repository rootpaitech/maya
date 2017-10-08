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
public class EmailResponseDTO {

  private String emailResponseContent;

  private boolean approvalEmail;

  private boolean bookingConfirmationEmail;

  private List<byte[]> tickets;
  
  
  /**
   * Default Constructor
   */
  public EmailResponseDTO() {
    
    this.tickets = new ArrayList<>();
  }
  
  public void addDocument(byte[] documentContent) {
    
    this.tickets.add(documentContent);
  }

  /**
   * @return the emailResponseContent
   */
  public String getEmailResponseContent() {

    return emailResponseContent;
  }

  /**
   * @param emailResponseContent the emailResponseContent to set
   */
  public void setEmailResponseContent(String emailResponseContent) {

    this.emailResponseContent = emailResponseContent;
  }

  /**
   * @return the approvalEmail
   */
  public boolean isApprovalEmail() {

    return approvalEmail;
  }

  /**
   * @param approvalEmail the approvalEmail to set
   */
  public void setApprovalEmail(boolean approvalEmail) {

    this.approvalEmail = approvalEmail;
  }

  /**
   * @return the bookingConfirmationEmail
   */
  public boolean isBookingConfirmationEmail() {

    return bookingConfirmationEmail;
  }

  /**
   * @param bookingConfirmationEmail the bookingConfirmationEmail to set
   */
  public void setBookingConfirmationEmail(boolean bookingConfirmationEmail) {

    this.bookingConfirmationEmail = bookingConfirmationEmail;
  }

  /**
   * @return the tickets
   */
  public List<byte[]> getTickets() {

    return tickets;
  }

  /**
   * @param tickets the tickets to set
   */
  public void setTickets(List<byte[]> tickets) {

    this.tickets = tickets;
  }
}
package com.rootpai.maya.web.api.mail.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rootpai.maya.batch.email.model.EmailResponseDTO;
import com.sun.mail.util.BASE64DecoderStream;

/**
 * @author agara
 *
 */
@Service
public class GmailService {

  private JavaMailSender sender;

  private Store store;

  public GmailService(JavaMailSender sender) throws IOException, MessagingException {

    this.sender = sender;

    File propertiesFiles = new ClassPathResource("application.properties").getFile();
    Properties properties = new Properties();
    properties.load(new FileInputStream(propertiesFiles));
    Session session = Session.getDefaultInstance(properties, null);
    this.store = session.getStore("imaps");
    this.store.connect("smtp.gmail.com", "agarwalankit1127@gmail.com", "ankit3124");
  }

  public void sendEmail(byte[] travelDocument) {

    try {
      MimeMessage message = sender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setTo("ankitrootpai@gmail.com");
      helper.setText(
          "Kindly approve the travel document for Ankit. Travel document attached.");
      helper.setSubject("Travel Request Approval");
      helper.addAttachment("travel_document.docx", new ByteArrayDataSource(travelDocument,
          MediaType.APPLICATION_OCTET_STREAM_VALUE));
      sender.send(message);
    }
    catch (MessagingException ex) {
      ex.printStackTrace();
    }
  }

  public EmailResponseDTO readEmail() {

    EmailResponseDTO emailResponseDTO = new EmailResponseDTO();
    try {
      Folder inbox = store.getFolder("Inbox");
      inbox.open(Folder.READ_ONLY);
      Message[] messages = inbox.getMessages();
      List<Message> messagesInList = Arrays.asList(messages);
      Collections.reverse(messagesInList);

      for (Message message : messagesInList) {
        if (message.getFrom()[0].toString().contains("smtmanager2017@gmail.com")
            && message.getSubject().equalsIgnoreCase("Travel Request Approval")) {
          emailResponseDTO = prepareEmailResponseDTOFromManagerEmail(message);
        }
        else if (message.getFrom()[0].toString().contains("rootpaitraveldesk@gmail.com")
            && message.getSubject().equalsIgnoreCase("Travel Request Booking")) {
          emailResponseDTO = prepareEmailResponseDTOFromTravelDeskEmail(message);
        }
      }
    }
    catch (MessagingException | IOException e) {
      e.printStackTrace();
    }
    return emailResponseDTO;
  }

  private EmailResponseDTO prepareEmailResponseDTOFromTravelDeskEmail(Message message)
      throws IOException, MessagingException {

    EmailResponseDTO emailResponseDTO = new EmailResponseDTO();
    emailResponseDTO.setBookingConfirmationEmail(Boolean.TRUE);

    if (message.getContentType().contains("multipart")) {
      Multipart multiPart = (Multipart) message.getContent();
      for (int partCount = 0; partCount < multiPart.getCount(); partCount++) {
        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          BASE64DecoderStream base64DecoderStream = (BASE64DecoderStream) part
              .getContent();
          int reads = base64DecoderStream.read();
          while (reads != -1) {
            baos.write(reads);
            reads = base64DecoderStream.read();
          }
          emailResponseDTO.addDocument(baos.toByteArray());
        }
      }
    }
    return emailResponseDTO;
  }

  private EmailResponseDTO prepareEmailResponseDTOFromManagerEmail(Message message)
      throws IOException, MessagingException {

    EmailResponseDTO emailResponseDTO = new EmailResponseDTO();
    emailResponseDTO.setApprovalEmail(Boolean.TRUE);
    Multipart multipart = (Multipart) message.getContent();
    for (int j = 0; j < multipart.getCount(); j++) {
      BodyPart bodyPart = multipart.getBodyPart(j);
      if (bodyPart.isMimeType("text/plain")) {
        emailResponseDTO.setEmailResponseContent(bodyPart.getContent().toString());
        break;
      }
    }
    return emailResponseDTO;
  }
}
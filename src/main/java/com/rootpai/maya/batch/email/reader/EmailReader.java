package com.rootpai.maya.batch.email.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.web.client.RestTemplate;

import com.rootpai.maya.batch.email.model.EmailResponseDTO;

/**
 * @author agara
 *
 */
public class EmailReader implements ItemReader<EmailResponseDTO> {

  private String apiUrl;

  private RestTemplate restTemplate;

  @Override
  public EmailResponseDTO read() throws Exception, UnexpectedInputException,
      ParseException, NonTransientResourceException {

    return null;
  }
}
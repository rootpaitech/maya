/**
 * 
 */
package com.rootpai.maya.web.api.message.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rootpai.maya.web.api.message.handler.MessageHandler;

/**
 * @author agara
 *
 */
@RestController
public class MayaWebApiRestController {

  private static final String APPLICATION_TYPE = "application/json";

  private static final Logger LOGGER = LoggerFactory
      .getLogger(MayaWebApiRestController.class);

  private MessageHandler messageHandler;

  public MayaWebApiRestController(MessageHandler messageHandler) {

    this.messageHandler = messageHandler;
  }

  @RequestMapping(value = "/processQuery", produces = APPLICATION_TYPE)
  public String processQuery(HttpServletRequest request, HttpServletResponse response,
      @RequestParam("message") String message,
      @RequestParam("employeeId") String employeeId) {

    LOGGER.info("Employee Id : " + employeeId + " & Message : " + message);
    return messageHandler.processMessage(message, employeeId);
  }
}
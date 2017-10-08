/**
 * 
 */
package com.rootpai.maya.web.api.message.handler;

import org.springframework.stereotype.Component;

import com.rootpai.maya.web.api.message.travel.dto.TravelRequestDTO;
import com.rootpai.maya.web.api.message.travel.handler.TravelRequestHandler;

/**
 * @author agara
 *
 */
@Component
public class MessageHandler {

  private TravelRequestHandler travelRequestHandler;

  public MessageHandler(TravelRequestHandler travelRequestHandler) {

    this.travelRequestHandler = travelRequestHandler;
  }

  public String processMessage(String message, String employeeId) {

    TravelRequestDTO travelRequestDTO = buildMessageRequestDTO();
    travelRequestHandler.processTravel(employeeId, travelRequestDTO);
    return "Bookings done";
  }

  private TravelRequestDTO buildMessageRequestDTO() {

    return new TravelRequestDTO("travel_schedule", "Delhi", "2017-10-20", "2017-10-22",
        "", "SMT Conference");
  }
}

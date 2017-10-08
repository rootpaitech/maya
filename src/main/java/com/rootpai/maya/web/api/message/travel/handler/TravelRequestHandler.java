/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.handler;

import org.springframework.stereotype.Component;

import com.rootpai.maya.web.api.employee.information.model.EmployeeInformation;
import com.rootpai.maya.web.api.employee.information.service.EmployeeInformationService;
import com.rootpai.maya.web.api.iatacodes.retrieve.service.RetrieveIATACodesService;
import com.rootpai.maya.web.api.mail.service.GmailService;
import com.rootpai.maya.web.api.message.travel.doc.generator.TravelDocGenerator;
import com.rootpai.maya.web.api.message.travel.dto.TravelRequestDTO;
import com.rootpai.maya.web.api.message.travel.options.request.builder.TravelOptionsRetrievalRequestBuilder;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelOptionsRetrievalRequestDTO;
import com.rootpai.maya.web.api.message.travel.options.response.model.TravelOptionsRetrievalResponseDTO;
import com.rootpai.maya.web.api.message.travel.options.service.TravelOptionsRetrievalService;

/**
 * @author agara
 *
 */
@Component
public class TravelRequestHandler {

  private EmployeeInformationService employeeInformationService;

  private TravelDocGenerator travelDocGenerator;

  private GmailService gmailService;

  private TravelOptionsRetrievalService travelOptionsRetrievalService;

  private RetrieveIATACodesService retrieveIATACodesService;

  public TravelRequestHandler(EmployeeInformationService employeeInformationService,
      TravelDocGenerator travelDocGenerator, GmailService gmailService,
      TravelOptionsRetrievalService travelOptionsRetrievalService,
      RetrieveIATACodesService retrieveIATACodesService) {

    this.employeeInformationService = employeeInformationService;
    this.travelDocGenerator = travelDocGenerator;
    this.gmailService = gmailService;
    this.travelOptionsRetrievalService = travelOptionsRetrievalService;
    this.retrieveIATACodesService = retrieveIATACodesService;
  }

  public void processTravel(String employeeId, TravelRequestDTO travelRequestDTO) {

    EmployeeInformation employeeInformation = employeeInformationService
        .retrieveEmployeeInformation(employeeId);
    EmployeeInformation employeeManagerInformation = employeeInformationService
        .retrieveEmployeeInformation(employeeInformation.getManagerId());

    byte[] travelDocument = travelDocGenerator.generateTravelDocument(employeeInformation,
        employeeManagerInformation, travelRequestDTO,
        getTravelOptionsResponseDTO(travelRequestDTO, employeeInformation));

    gmailService.sendEmail(travelDocument);
  }

  private TravelOptionsRetrievalResponseDTO getTravelOptionsResponseDTO(
      TravelRequestDTO travelRequestDTO, EmployeeInformation employeeInformation) {

    TravelOptionsRetrievalRequestDTO travelOptionsRetrievalRequestDTO = TravelOptionsRetrievalRequestBuilder
        .buildTravelOptionsRetrievalRequestDTO(employeeInformation.getCurrentLocation(),
            travelRequestDTO, retrieveIATACodesService.retrieveIATACodes());
    TravelOptionsRetrievalResponseDTO travelOptionsRetrievalResponseDTO = travelOptionsRetrievalService
        .retrieveTravelFlightOptions(travelOptionsRetrievalRequestDTO);
    travelOptionsRetrievalResponseDTO.setHotelOptionsAPIResponse(
        travelOptionsRetrievalService.retrieveHotelOptions("Hotels in Whitefield"));
    return travelOptionsRetrievalResponseDTO;
  }
}
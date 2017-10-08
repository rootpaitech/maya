/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.doc.generator;

import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rootpai.maya.web.api.employee.information.model.EmployeeInformation;
import com.rootpai.maya.web.api.message.travel.dto.TravelRequestDTO;
import com.rootpai.maya.web.api.message.travel.options.response.model.TravelOptionsRetrievalResponseDTO;

import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.DocxTemplate;

/**
 * @author agara
 *
 */
@Service
public class TravelDocGenerator {

  private DocxTemplate template;

  private String documentPath;

  public TravelDocGenerator() throws URISyntaxException {

    this.template = new DocxTemplate();
    // this.template.setVariablePattern(new VariablePattern("#{", "}"));

    this.documentPath = Paths
        .get(getClass().getClassLoader()
            .getResource("travel-forms/Travel_Request_Form.docx").toURI())
        .normalize().toString();
  }

  public byte[] generateTravelDocument(EmployeeInformation employeeInformation,
      EmployeeInformation employeeManagerInformation, TravelRequestDTO travelRequestDTO,
      TravelOptionsRetrievalResponseDTO travelOptionsRetrievalResponseDTO) {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Map<String, String> variables = getTemplateVariables(employeeInformation,
        employeeManagerInformation, travelRequestDTO, travelOptionsRetrievalResponseDTO);
    Docx docx = template.fillTemplate(documentPath, variables);
    template.save(docx, outputStream);
    return outputStream.toByteArray();
  }

  private Map<String, String> getTemplateVariables(
      EmployeeInformation employeeInformation,
      EmployeeInformation employeeManagerInformation, TravelRequestDTO travelRequestDTO,
      TravelOptionsRetrievalResponseDTO travelOptionsRetrievalResponseDTO) {

    Map<String, String> variables = new HashMap<>();
    variables.put("requestSubmissionDate", LocalDate.now().toString());
    variables.put("requesterName", employeeInformation.getName());
    variables.put("employeeId", employeeInformation.getId());
    variables.put("employeeCostCode", employeeInformation.getCostCode());
    variables.put("employeeEmail", employeeInformation.getEmail());
    variables.put("employeePrimaryNumber", employeeInformation.getNumber());
    variables.put("employeeDepartment", employeeInformation.getDepartment());

    variables.put("source", employeeInformation.getCurrentLocation());
    variables.put("destination", travelRequestDTO.getDestination());
    variables.put("departureDate", travelRequestDTO.getStartDate());
    variables.put("returnDate", travelRequestDTO.getEndDate());
    variables.put("purpose", travelRequestDTO.getReason());
    variables.put("managerName", employeeManagerInformation.getName());
    variables.put("managerEmail", employeeManagerInformation.getEmail());
    variables.put("managerApprovalEmailAttached", "");
    variables.put("approvalDate", "");

    variables.put("depFlightNumber", travelOptionsRetrievalResponseDTO
        .getOnwardTripOptions().get(0).getFlightNumber());
    variables.put("depTime", travelOptionsRetrievalResponseDTO.getOnwardTripOptions()
        .get(0).getDepartureTime());
    variables.put("depArrivalTime",
        travelOptionsRetrievalResponseDTO.getOnwardTripOptions().get(0).getArrivalTime());

    variables.put("returnFlightNumber", travelOptionsRetrievalResponseDTO
        .getReturnTripOptions().get(0).getFlightNumber());
    variables.put("returnDepTime", travelOptionsRetrievalResponseDTO
        .getReturnTripOptions().get(0).getDepartureTime());
    variables.put("returnArrivalTime",
        travelOptionsRetrievalResponseDTO.getReturnTripOptions().get(0).getArrivalTime());

    variables.put("hotelName", travelOptionsRetrievalResponseDTO
        .getHotelOptionsAPIResponse().getResults().get(0).getName());
    variables.put("hotelAddress", travelOptionsRetrievalResponseDTO
        .getHotelOptionsAPIResponse().getResults().get(0).getAddress());
    variables.put("checkInDate", travelRequestDTO.getStartDate());
    variables.put("checkOutDate", travelRequestDTO.getEndDate());

    return variables;
  }
}
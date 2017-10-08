/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.request.builder;

import java.util.ArrayList;
import java.util.List;

import com.rootpai.maya.web.api.iatacodes.retrieve.response.model.IATACodesResponse;
import com.rootpai.maya.web.api.message.travel.dto.TravelRequestDTO;
import com.rootpai.maya.web.api.message.travel.options.request.model.PermittedDepartureTime;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelDetails;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelOptionsRetrievalRequest;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelOptionsRetrievalRequestDTO;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelPassengersDetails;

/**
 * @author agara
 *
 */
public interface TravelOptionsRetrievalRequestBuilder {

  public static TravelOptionsRetrievalRequestDTO buildTravelOptionsRetrievalRequestDTO(
      String origin, TravelRequestDTO travelRequestDTO,
      IATACodesResponse iataCodesResponse) {

    return new TravelOptionsRetrievalRequestDTO(new TravelOptionsRetrievalRequest(
        getTravelPassengerDetails(),
        getTravelDetails(origin, travelRequestDTO, iataCodesResponse), Boolean.TRUE, 3));
  }

  static List<TravelDetails> getTravelDetails(String origin,
      TravelRequestDTO travelRequestDTO, IATACodesResponse iataCodesResponse) {

    List<TravelDetails> travelDetails = new ArrayList<>();
    TravelDetails onwardJourneyTravelDetails = new TravelDetails(
        iataCodesResponse.getIATACode(origin),
        iataCodesResponse.getIATACode(travelRequestDTO.getDestination()),
        travelRequestDTO.getStartDate(), 0, 0,
        new PermittedDepartureTime("06:00", "08:00"));

    TravelDetails returnJourneyTravelDetails = new TravelDetails(
        iataCodesResponse.getIATACode(travelRequestDTO.getDestination()),
        iataCodesResponse.getIATACode(origin), travelRequestDTO.getEndDate(), 0, 0,
        new PermittedDepartureTime("20:00", "22:00"));

    travelDetails.add(onwardJourneyTravelDetails);
    travelDetails.add(returnJourneyTravelDetails);

    return travelDetails;
  }

  static TravelPassengersDetails getTravelPassengerDetails() {

    return new TravelPassengersDetails(1);
  }
}
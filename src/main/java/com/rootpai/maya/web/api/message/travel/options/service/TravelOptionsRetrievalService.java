/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rootpai.maya.web.api.message.travel.options.api.response.model.HotelOptionsAPIResponse;
import com.rootpai.maya.web.api.message.travel.options.api.response.model.Leg;
import com.rootpai.maya.web.api.message.travel.options.api.response.model.OptionsSlice;
import com.rootpai.maya.web.api.message.travel.options.api.response.model.Segment;
import com.rootpai.maya.web.api.message.travel.options.api.response.model.TravelOptionsRetrievalAPIResponse;
import com.rootpai.maya.web.api.message.travel.options.api.response.model.TripOptions;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelDetails;
import com.rootpai.maya.web.api.message.travel.options.request.model.TravelOptionsRetrievalRequestDTO;
import com.rootpai.maya.web.api.message.travel.options.response.model.TravelOptionsRetrievalResponseDTO;
import com.rootpai.maya.web.api.message.travel.options.response.model.TripRetrievedOtions;

/**
 * @author agara
 *
 */
@Service
public class TravelOptionsRetrievalService {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(TravelOptionsRetrievalService.class);

  @Value("${googleapis.qpxExpress.trips.api.url}")
  private String googleQpxExpressTripsApiUrl;

  @Value("${googleapis.textsearch.api.url}")
  private String googleTextSearchApiUrl;

  private RestTemplate restTemplate;

  public TravelOptionsRetrievalService(
      @Qualifier("restTemplate") RestTemplate restTemplate) {

    this.restTemplate = restTemplate;
  }

  public TravelOptionsRetrievalResponseDTO retrieveTravelFlightOptions(
      TravelOptionsRetrievalRequestDTO travelOptionsRetrievalRequestDTO) {

    try {
      ResponseEntity<TravelOptionsRetrievalAPIResponse> responseEntity = restTemplate
          .postForEntity(googleQpxExpressTripsApiUrl, travelOptionsRetrievalRequestDTO,
              TravelOptionsRetrievalAPIResponse.class);
      return getTravelOptionsRetrievalResponseDTO(travelOptionsRetrievalRequestDTO,
          responseEntity.getBody());
    }
    catch (Exception ex) {
      LOGGER.error("Error invoking Google QPXExpress Travel API", ex);
      return null;
    }
  }

  public HotelOptionsAPIResponse retrieveHotelOptions(String queryText) {

    try {
      ResponseEntity<HotelOptionsAPIResponse> responseEntity = restTemplate.getForEntity(
          googleTextSearchApiUrl + queryText, HotelOptionsAPIResponse.class);
      return responseEntity.getBody();
    }
    catch (Exception ex) {
      LOGGER.error("Error invoking Google Text Search API", ex);
      return null;
    }
  }

  private TravelOptionsRetrievalResponseDTO getTravelOptionsRetrievalResponseDTO(
      TravelOptionsRetrievalRequestDTO travelOptionsRetrievalRequestDTO,
      TravelOptionsRetrievalAPIResponse travelOptionsRetrievalAPIResponse) {

    TravelDetails onwardTravelDetails = travelOptionsRetrievalRequestDTO
        .getTravelOptionsRetrievalRequest().getTravelDetails().get(0);

    List<TripRetrievedOtions> onwardTripOptions = new ArrayList<>();
    List<TripRetrievedOtions> returnTripOptions = new ArrayList<>();

    for (TripOptions tripOptions : travelOptionsRetrievalAPIResponse.getTrips()
        .getTripOptions()) {
      for (OptionsSlice optionsSlice : tripOptions.getSlice()) {
        for (Segment segment : optionsSlice.getSegments()) {
          for (Leg leg : segment.getLegs()) {
            if (onwardTravelDetails.getOrigin().equalsIgnoreCase(leg.getOrigin())) {
              onwardTripOptions.add(new TripRetrievedOtions(
                  segment.getFlight().getCarrier() + segment.getFlight().getNumber(),
                  leg.getDepartureTime(), leg.getArrivalTime()));
            }
            else if (onwardTravelDetails.getDestination()
                .equalsIgnoreCase(leg.getOrigin())) {
              returnTripOptions.add(new TripRetrievedOtions(
                  segment.getFlight().getCarrier() + segment.getFlight().getNumber(),
                  leg.getDepartureTime(), leg.getArrivalTime()));
            }
          }
        }
      }
    }
    return new TravelOptionsRetrievalResponseDTO(onwardTripOptions, returnTripOptions);
  }
}
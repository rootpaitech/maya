package com.rootpai.maya.web.api.message.travel.options.request.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelOptionsRetrievalRequest {

  @JsonProperty("passengers")
  private TravelPassengersDetails travelPassengersDetails;

  @JsonProperty("slice")
  private List<TravelDetails> travelDetails;

  private boolean refundable;

  private int solutions;

  /**
   * @param travelPassengersDetails
   * @param travelDetails
   * @param refundable
   * @param solutions
   */
  public TravelOptionsRetrievalRequest(TravelPassengersDetails travelPassengersDetails,
      List<TravelDetails> travelDetails, boolean refundable, int solutions) {

    this.travelPassengersDetails = travelPassengersDetails;
    this.travelDetails = travelDetails;
    this.refundable = refundable;
    this.solutions = solutions;
  }

  /**
   * @return travelPassengersDetails
   */
  public TravelPassengersDetails getTravelPassengersDetails() {

    return travelPassengersDetails;
  }

  /**
   * @return travelDetails
   */
  public List<TravelDetails> getTravelDetails() {

    return travelDetails;
  }

  /**
   * @return refundable
   */
  public boolean isRefundable() {

    return refundable;
  }

  /**
   * @return solutions
   */
  public int getSolutions() {

    return solutions;
  }
}
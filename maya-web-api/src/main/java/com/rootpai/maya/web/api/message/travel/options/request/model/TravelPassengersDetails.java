package com.rootpai.maya.web.api.message.travel.options.request.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelPassengersDetails {

  private String kind;

  private int adultCount;

  /**
   * @param kind
   * @param adultCount
   */
  public TravelPassengersDetails(int adultCount) {

    this.kind = "qpxexpress#passengerCounts";
    this.adultCount = adultCount;
  }

  /**
   * @return the kind
   */
  public String getKind() {

    return kind;
  }

  /**
   * @return the adultCount
   */
  public int getAdultCount() {

    return adultCount;
  }
}
/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.api.response.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Leg {

  @JsonProperty("arrivalTime")
  private String arrivalTime;

  @JsonProperty("departureTime")
  private String departureTime;

  @JsonProperty("origin")
  private String origin;

  @JsonProperty("destination")
  private String destination;

  /**
   * @return the arrivalTime
   */
  public String getArrivalTime() {

    return arrivalTime;
  }

  /**
   * @param arrivalTime the arrivalTime to set
   */
  public void setArrivalTime(String arrivalTime) {

    this.arrivalTime = arrivalTime;
  }

  /**
   * @return the departureTime
   */
  public String getDepartureTime() {

    return departureTime;
  }

  /**
   * @param departureTime the departureTime to set
   */
  public void setDepartureTime(String departureTime) {

    this.departureTime = departureTime;
  }

  /**
   * @return the origin
   */
  public String getOrigin() {

    return origin;
  }

  /**
   * @param origin the origin to set
   */
  public void setOrigin(String origin) {

    this.origin = origin;
  }

  /**
   * @return the destination
   */
  public String getDestination() {

    return destination;
  }

  /**
   * @param destination the destination to set
   */
  public void setDestination(String destination) {

    this.destination = destination;
  }
}

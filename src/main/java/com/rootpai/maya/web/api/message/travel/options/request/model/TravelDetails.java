/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.request.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelDetails {

  private String kind;

  private String origin;

  private String destination;

  private String date;

  private int maxStops;

  private int maxConnectionDuration;

  private PermittedDepartureTime permittedDepartureTime;

  /**
   * @param kind
   * @param origin
   * @param destination
   * @param date
   * @param maxStops
   * @param maxConnectionDuration
   * @param permittedDepartureTime
   */
  public TravelDetails(String origin, String destination, String date, int maxStops,
      int maxConnectionDuration, PermittedDepartureTime permittedDepartureTime) {

    this.kind = "qpxexpress#sliceInput";
    this.origin = origin;
    this.destination = destination;
    this.date = date;
    this.maxStops = maxStops;
    this.maxConnectionDuration = maxConnectionDuration;
    this.permittedDepartureTime = permittedDepartureTime;
  }

  /**
   * @return the kind
   */
  public String getKind() {

    return kind;
  }

  /**
   * @return the origin
   */
  public String getOrigin() {

    return origin;
  }

  /**
   * @return the destination
   */
  public String getDestination() {

    return destination;
  }

  /**
   * @return the date
   */
  public String getDate() {

    return date;
  }

  /**
   * @return the maxStops
   */
  public int getMaxStops() {

    return maxStops;
  }

  /**
   * @return the maxConnectionDuration
   */
  public int getMaxConnectionDuration() {

    return maxConnectionDuration;
  }

  /**
   * @return the permittedDepartureTime
   */
  public PermittedDepartureTime getPermittedDepartureTime() {

    return permittedDepartureTime;
  }
}
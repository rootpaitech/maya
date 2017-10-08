/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.response.model;

/**
 * @author agara
 *
 */
public class TripRetrievedOtions {

  private String flightNumber;

  private String departureTime;

  private String arrivalTime;

  /**
   * @param flightNumber
   * @param departureTime
   * @param arrivalTime
   */
  public TripRetrievedOtions(String flightNumber, String departureTime,
      String arrivalTime) {

    this.flightNumber = flightNumber;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
  }

  /**
   * @return the flightNumber
   */
  public String getFlightNumber() {

    return flightNumber;
  }

  /**
   * @return the departureTime
   */
  public String getDepartureTime() {

    return departureTime;
  }

  /**
   * @return the arrivalTime
   */
  public String getArrivalTime() {

    return arrivalTime;
  }
}
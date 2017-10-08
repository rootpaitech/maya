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
public class PermittedDepartureTime {

  private String kind;

  private String earliestTime;

  private String latestTime;

  /**
   * @param earliestTime
   * @param latestTime
   */
  public PermittedDepartureTime(String earliestTime, String latestTime) {

    this.kind = "qpxexpress#timeOfDayRange";
    this.earliestTime = earliestTime;
    this.latestTime = latestTime;
  }

  /**
   * @return the kind
   */
  public String getKind() {

    return kind;
  }

  /**
   * @return the earliestTime
   */
  public String getEarliestTime() {

    return earliestTime;
  }

  /**
   * @return the latestTime
   */
  public String getLatestTime() {

    return latestTime;
  }
}

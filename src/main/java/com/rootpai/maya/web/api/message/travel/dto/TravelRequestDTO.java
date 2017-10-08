package com.rootpai.maya.web.api.message.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelRequestDTO {

  private String intent;

  private String destination;

  private String startDate;

  private String endDate;

  private String duration;

  private String reason;

  public TravelRequestDTO() {
    // TODO Auto-generated constructor stub
  }

  public TravelRequestDTO(String intent, String destination, String startDate,
      String endDate, String duration, String reason) {

    this.intent = intent;
    this.destination = destination;
    this.startDate = startDate;
    this.endDate = endDate;
    this.duration = duration;
    this.reason = reason;
  }

  public String getIntent() {

    return intent;
  }

  public String getDestination() {

    return destination;
  }

  public String getStartDate() {

    return startDate;
  }

  public String getEndDate() {

    return endDate;
  }

  public String getDuration() {

    return duration;
  }

  public String getReason() {

    return reason;
  }

}
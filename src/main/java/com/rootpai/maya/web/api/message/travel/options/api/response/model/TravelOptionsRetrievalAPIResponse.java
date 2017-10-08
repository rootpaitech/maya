package com.rootpai.maya.web.api.message.travel.options.api.response.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelOptionsRetrievalAPIResponse {

  @JsonProperty("kind")
  private String kind;

  @JsonProperty("trips")
  private Trips trips;

  public List<TripOptions> getTripOptions(String origin) {

    return trips.getTripOptionsForOrigin(origin);
  }

  /**
   * @return the kind
   */
  public String getKind() {

    return kind;
  }

  /**
   * @param kind the kind to set
   */
  public void setKind(String kind) {

    this.kind = kind;
  }

  /**
   * @return the trips
   */
  public Trips getTrips() {

    return trips;
  }

  /**
   * @param trips the trips to set
   */
  public void setTrips(Trips trips) {

    this.trips = trips;
  }
}
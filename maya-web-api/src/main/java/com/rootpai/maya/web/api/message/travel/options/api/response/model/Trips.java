/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.api.response.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trips {

  @JsonProperty("tripOption")
  private List<TripOptions> tripOptions;

  public Trips() {

    this.tripOptions = new ArrayList<>();
  }

  public List<TripOptions> getTripOptionsForOrigin(String origin) {

    return tripOptions.stream().filter(Objects::nonNull)
        .filter(tripOption -> tripOption.getSlice(origin)).collect(Collectors.toList());
  }

  /**
   * @return the tripOptions
   */
  public List<TripOptions> getTripOptions() {

    return tripOptions;
  }

  /**
   * @param tripOptions the tripOptions to set
   */
  public void setTripOptions(List<TripOptions> tripOptions) {

    this.tripOptions = tripOptions;
  }
}
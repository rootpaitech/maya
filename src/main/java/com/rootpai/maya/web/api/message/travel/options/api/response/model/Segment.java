/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.api.response.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {

  @JsonProperty("flight")
  private Flight flight;

  @JsonProperty("leg")
  private List<Leg> legs;

  public Segment() {

    this.legs = new ArrayList<>();
  }

  public boolean getLeg(String origin) {

    Optional<Leg> optionalLeg = legs.stream().filter(Objects::nonNull)
        .filter(leg -> origin.equalsIgnoreCase(leg.getOrigin())).findFirst();
    return optionalLeg.isPresent() ? Boolean.TRUE : Boolean.FALSE;
  }

  /**
   * @return the flight
   */
  public Flight getFlight() {

    return flight;
  }

  /**
   * @param flight the flight to set
   */
  public void setFlight(Flight flight) {

    this.flight = flight;
  }

  /**
   * @return the legs
   */
  public List<Leg> getLegs() {

    return legs;
  }

  /**
   * @param legs the legs to set
   */
  public void setLegs(List<Leg> legs) {

    this.legs = legs;
  }
}
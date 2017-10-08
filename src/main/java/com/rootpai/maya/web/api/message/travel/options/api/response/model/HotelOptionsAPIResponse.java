/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.api.response.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelOptionsAPIResponse {

  @JsonProperty("results")
  private List<HotelOptionsResult> results;

  /**
   * Default Constructor
   */
  public HotelOptionsAPIResponse() {

    this.results = new ArrayList<>();
  }

  /**
   * @return the results
   */
  public List<HotelOptionsResult> getResults() {

    return results;
  }

  /**
   * @param results the results to set
   */
  public void setResults(List<HotelOptionsResult> results) {

    this.results = results;
  }
}
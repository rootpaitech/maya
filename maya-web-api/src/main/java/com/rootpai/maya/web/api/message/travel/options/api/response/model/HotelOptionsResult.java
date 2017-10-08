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
public class HotelOptionsResult {

  @JsonProperty("formatted_address")
  private String address;

  @JsonProperty("name")
  private String name;

  @JsonProperty("rating")
  private String rating;

  /**
   * @return the address
   */
  public String getAddress() {

    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {

    this.address = address;
  }

  /**
   * @return the name
   */
  public String getName() {

    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return the rating
   */
  public String getRating() {

    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(String rating) {

    this.rating = rating;
  }
}
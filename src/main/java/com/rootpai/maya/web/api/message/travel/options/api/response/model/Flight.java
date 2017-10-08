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
public class Flight {

  @JsonProperty("carrier")
  private String carrier;

  @JsonProperty("number")
  private String number;

  /**
   * @return the carrier
   */
  public String getCarrier() {

    return carrier;
  }

  /**
   * @param carrier the carrier to set
   */
  public void setCarrier(String carrier) {

    this.carrier = carrier;
  }

  /**
   * @return the number
   */
  public String getNumber() {

    return number;
  }

  /**
   * @param number the number to set
   */
  public void setNumber(String number) {

    this.number = number;
  }
}
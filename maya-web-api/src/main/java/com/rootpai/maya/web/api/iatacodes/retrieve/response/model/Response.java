/**
 * 
 */
package com.rootpai.maya.web.api.iatacodes.retrieve.response.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

  @JsonProperty("code")
  private String code;

  @JsonProperty("country_code")
  private String countryCode;

  @JsonProperty("name")
  private String name;

  /**
   * @return the code
   */
  public String getCode() {

    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(String code) {

    this.code = code;
  }

  /**
   * @return the countryCode
   */
  public String getCountryCode() {

    return countryCode;
  }

  /**
   * @param countryCode the countryCode to set
   */
  public void setCountryCode(String countryCode) {

    this.countryCode = countryCode;
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
}
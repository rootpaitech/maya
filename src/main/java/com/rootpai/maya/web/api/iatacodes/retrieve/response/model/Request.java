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
public class Request {

  @JsonProperty("lang")
  private String lang;

  /**
   * @return the lang
   */
  public String getLang() {

    return lang;
  }

  /**
   * @param lang the lang to set
   */
  public void setLang(String lang) {

    this.lang = lang;
  }
}
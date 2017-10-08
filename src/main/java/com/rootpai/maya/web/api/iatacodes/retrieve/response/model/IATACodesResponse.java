/**
 * 
 */
package com.rootpai.maya.web.api.iatacodes.retrieve.response.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IATACodesResponse {

  @JsonProperty("request")
  private Request request;

  @JsonProperty("response")
  private List<Response> responses;

  public IATACodesResponse() {

    this.responses = new ArrayList<>();
  }

  public IATACodesResponse(List<Response> responses) {

    this.responses = responses;
  }

  /**
   * @param name
   * @return the IATA Code
   */
  public String getIATACode(String name) {

    Optional<Response> optionalResponse = responses.stream().filter(Objects::nonNull)
        .filter(response -> StringUtils.equalsIgnoreCase(response.getName(), name)
            || StringUtils.containsIgnoreCase(response.getName(), name))
        .findFirst();
    return optionalResponse.isPresent() ? optionalResponse.get().getCode() : "";
  }

  /**
   * @return the responses
   */
  public List<Response> getResponses() {

    return responses;
  }

  /**
   * @param responses the responses to set
   */
  public void setResponses(List<Response> responses) {

    this.responses = responses;
  }

  /**
   * @return the request
   */
  public Request getRequest() {

    return request;
  }

  /**
   * @param request the request to set
   */
  public void setRequest(Request request) {

    this.request = request;
  }
}
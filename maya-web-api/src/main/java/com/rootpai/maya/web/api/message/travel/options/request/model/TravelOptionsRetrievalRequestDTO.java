/**
 * 
 */
package com.rootpai.maya.web.api.message.travel.options.request.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author agara
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelOptionsRetrievalRequestDTO {

  @JsonProperty("request")
  private TravelOptionsRetrievalRequest travelOptionsRetrievalRequest;

  /**
   * @param travelOptionsRetrievalRequest
   */
  public TravelOptionsRetrievalRequestDTO(
      TravelOptionsRetrievalRequest travelOptionsRetrievalRequest) {

    this.travelOptionsRetrievalRequest = travelOptionsRetrievalRequest;
  }

  /**
   * @return travelOptionsRetrievalRequest
   */
  public TravelOptionsRetrievalRequest getTravelOptionsRetrievalRequest() {

    return travelOptionsRetrievalRequest;
  }
}
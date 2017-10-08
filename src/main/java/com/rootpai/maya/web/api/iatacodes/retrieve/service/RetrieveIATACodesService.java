/**
 * 
 */
package com.rootpai.maya.web.api.iatacodes.retrieve.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rootpai.maya.web.api.iatacodes.retrieve.response.model.IATACodesResponse;

/**
 * @author agara
 *
 */
@Service
public class RetrieveIATACodesService {

  @Value("${iatacodes.cities.api.url}")
  private String iataCityCodesApiUrl;

  private RestTemplate restTemplate;

  /**
   * @param restTemplate
   */
  public RetrieveIATACodesService(@Qualifier("restTemplate") RestTemplate restTemplate) {

    this.restTemplate = restTemplate;
  }

  /**
   * @return the IATACodesResponse
   */
  public IATACodesResponse retrieveIATACodes() {

    ResponseEntity<IATACodesResponse> responseEntity = restTemplate
        .getForEntity(iataCityCodesApiUrl, IATACodesResponse.class);
    return responseEntity.getBody();
  }
}
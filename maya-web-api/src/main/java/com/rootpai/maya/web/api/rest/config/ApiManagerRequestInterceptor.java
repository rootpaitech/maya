package com.rootpai.maya.web.api.rest.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.StreamUtils;

public class ApiManagerRequestInterceptor implements ClientHttpRequestInterceptor {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(ApiManagerRequestInterceptor.class);

  @Override
  public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] requestBody,
      ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

    HttpRequest httpRequestWrapper = addHeadersToRequest(httpRequest);
    logRequestMessage(httpRequestWrapper, requestBody);

    long startTimeInMillis = System.currentTimeMillis();
    BufferingHttpResponseWrapper clientHttpResponse = new BufferingHttpResponseWrapper(
        clientHttpRequestExecution.execute(httpRequestWrapper, requestBody));
    logResponseMessage(clientHttpResponse,
        System.currentTimeMillis() - startTimeInMillis);
    return clientHttpResponse;
  }

  private HttpRequest addHeadersToRequest(HttpRequest httpRequest) {

    HttpRequest httpRequestWrapper = new HttpRequestWrapper(httpRequest);
    httpRequestWrapper.getHeaders().add("Accept", MediaType.APPLICATION_JSON_VALUE);
    httpRequestWrapper.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    // httpRequestWrapper.getHeaders().add("Authorization", "Bearer
    // ff873c96163b4bd5b92f8c81fa203891");
    return httpRequestWrapper;
  }

  private void logRequestMessage(HttpRequest httpRequest, byte[] requestBody) {

    LOGGER.info("Request Headers - " + httpRequest.getHeaders());
    LOGGER.info("Request Body - " + new String(requestBody));
  }

  private void logResponseMessage(ClientHttpResponse clientHttpResponse,
      long responseTime) throws IOException {

    byte[] responseBody = StreamUtils.copyToByteArray(clientHttpResponse.getBody());
    LOGGER.info("Response Time - " + responseTime);
    LOGGER.info("Response Headers - " + clientHttpResponse.getHeaders());
    LOGGER.info("Response Body - " + new String(responseBody));
  }
}
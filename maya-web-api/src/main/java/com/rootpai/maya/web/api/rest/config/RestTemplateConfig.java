package com.rootpai.maya.web.api.rest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

  @Bean(name = "restTemplate")
  public RestTemplate restTemplate() {

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setMessageConverters(messageConvertors());
    restTemplate.setInterceptors(clientHttpRequestInterceptors());
    return restTemplate;
  }

  private List<HttpMessageConverter<?>> messageConvertors() {

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    messageConverters.add(new StringHttpMessageConverter());
    messageConverters.add(new MappingJackson2HttpMessageConverter());
    return messageConverters;
  }

  private List<ClientHttpRequestInterceptor> clientHttpRequestInterceptors() {

    ArrayList<ClientHttpRequestInterceptor> clientHttpRequestInterceptors = new ArrayList<>();
    clientHttpRequestInterceptors.add(new ApiManagerRequestInterceptor());
    return clientHttpRequestInterceptors;
  }
}
package com.rootpai.maya.web.api;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MayaWebApiApplication {

  public static void main(String[] args) {

    SpringApplication.run(MayaWebApiApplication.class, args);
  }

  @Bean
  public ServletRegistrationBean h2servletRegistration() {

    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
    registration.addUrlMappings("/h2-console/*");
    return registration;
  }
}
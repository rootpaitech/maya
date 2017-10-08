package com.rootpai.maya.web.api.employee.information.model;

public class EmployeeInformation {

  private String id;

  private String name;

  private String email;

  private String number;

  private String department;

  private String costCode;

  private String currentLocation;

  private String managerId;

  public String getId() {

    return id;
  }

  public void setId(String id) {

    this.id = id;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public String getNumber() {

    return number;
  }

  public void setNumber(String number) {

    this.number = number;
  }

  public String getDepartment() {

    return department;
  }

  public void setDepartment(String department) {

    this.department = department;
  }

  public String getCostCode() {

    return costCode;
  }

  public void setCostCode(String costCode) {

    this.costCode = costCode;
  }

  public String getCurrentLocation() {

    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {

    this.currentLocation = currentLocation;
  }

  public String getManagerId() {

    return managerId;
  }

  public void setManagerId(String managerId) {

    this.managerId = managerId;
  }
}
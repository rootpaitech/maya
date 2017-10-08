package com.rootpai.maya.web.api.employee.information.service;

import org.springframework.stereotype.Service;

import com.rootpai.maya.web.api.employee.information.dao.EmployeeDAO;
import com.rootpai.maya.web.api.employee.information.model.EmployeeInformation;

@Service
public class EmployeeInformationService {

  private EmployeeDAO employeeDAO;

  public EmployeeInformationService(EmployeeDAO employeeDAO) {

    this.employeeDAO = employeeDAO;
  }

  public EmployeeInformation retrieveEmployeeInformation(String employeeId) {

    return employeeDAO.retrieveEmployeeInformation(employeeId);
  }
}
package com.rootpai.maya.web.api.employee.information.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rootpai.maya.web.api.employee.information.model.EmployeeInformation;

@Repository
public class EmployeeDAO {

  private JdbcTemplate jdbcTemplate;

  private String retrieveEmployeeInformationQuery = "select * from t_employee_info where emp_id = ?";

  public EmployeeDAO(DataSource dataSource) {

    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  private static final RowMapper<EmployeeInformation> ROW_MAPPER = new RowMapper<EmployeeInformation>() {

    @Override
    public EmployeeInformation mapRow(ResultSet resultSet, int rowNumber)
        throws SQLException {

      EmployeeInformation employeeInformation = new EmployeeInformation();
      employeeInformation.setId(resultSet.getString("emp_id"));
      employeeInformation.setName(resultSet.getString("emp_name"));
      employeeInformation.setEmail(resultSet.getString("emp_email"));
      employeeInformation.setNumber(resultSet.getString("emp_number"));
      employeeInformation.setDepartment(resultSet.getString("emp_dept"));
      employeeInformation.setCostCode(resultSet.getString("emp_cost_code"));
      employeeInformation.setCurrentLocation(resultSet.getString("emp_location"));
      employeeInformation.setManagerId(resultSet.getString("emp_manager"));
      return employeeInformation;
    }
  };

  public EmployeeInformation retrieveEmployeeInformation(String employeeId) {

    return jdbcTemplate.queryForObject(retrieveEmployeeInformationQuery, ROW_MAPPER,
        employeeId);
  }
}
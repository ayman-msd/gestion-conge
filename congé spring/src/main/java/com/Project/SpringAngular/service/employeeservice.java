package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.employeeDTO;
import com.Project.SpringAngular.DTO.employeesaveDTO;
import com.Project.SpringAngular.DTO.employeeupdateDTO;

import java.util.List;

public interface employeeservice {
    String addemployee(employeesaveDTO employeesaveDTO);

    List<employeeDTO> getallemployees();

    String updateemployee(employeeupdateDTO employeeupdateDTO);

    boolean deleteemployee(int id);
}

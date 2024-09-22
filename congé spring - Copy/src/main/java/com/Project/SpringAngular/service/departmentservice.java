package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.departmentDTO;
import com.Project.SpringAngular.DTO.departmentsaveDTO;
import com.Project.SpringAngular.DTO.departmentupdateDTO;

import java.util.List;

public interface departmentservice {
    String adddepartment(departmentsaveDTO departmentsaveDTO);

    List<departmentDTO> getalldepartments();

    String updatedepartment(departmentupdateDTO departmentupdateDTO);

    boolean deletedepartment(int id);
}

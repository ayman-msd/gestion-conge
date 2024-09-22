package com.Project.SpringAngular.departmentcontroller;

import com.Project.SpringAngular.DTO.departmentDTO;
import com.Project.SpringAngular.DTO.departmentsaveDTO;
import com.Project.SpringAngular.DTO.departmentupdateDTO;
import com.Project.SpringAngular.service.departmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/department")
public class departmentcontroller {

    @Autowired
    private departmentservice departmentservice;

    @PostMapping(path ="/save")
    public String savedepartment(@RequestBody departmentsaveDTO departmentsaveDTO) {
        String id = departmentservice.adddepartment(departmentsaveDTO);
        return id;
    }

    @GetMapping(path ="/getalldepartments")
    public List<departmentDTO> getalldepartments(){
        List<departmentDTO>alldepartments=departmentservice.getalldepartments();
        return alldepartments;
    }

    @PostMapping(path ="/update")
    public String updatedepartment(@RequestBody departmentupdateDTO departmentupdateDTO) {
        String id = departmentservice.updatedepartment(departmentupdateDTO);
        return id;
    }

    @DeleteMapping(path ="/deletedepartment/{id}")
    public String deletedepartment(@PathVariable(value="id") int id) {
        boolean deletedepartment = departmentservice.deletedepartment(id);
        return "department deleted";
    }


}

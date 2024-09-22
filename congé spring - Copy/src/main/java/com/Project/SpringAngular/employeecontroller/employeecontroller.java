package com.Project.SpringAngular.employeecontroller;

import com.Project.SpringAngular.DTO.employeeDTO;
import com.Project.SpringAngular.DTO.employeesaveDTO;
import com.Project.SpringAngular.DTO.employeeupdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Project.SpringAngular.service.employeeservice;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class employeecontroller {

    @Autowired
    private employeeservice employeeservice;

    @PostMapping(path ="/save")
    public String saveemployee(@RequestBody employeesaveDTO employeesaveDTO) {
        String id = employeeservice.addemployee(employeesaveDTO);
        return id;
    }

    @GetMapping(path ="/getallemployees")
    public List<employeeDTO> getallemployees(){
        List<employeeDTO>allemployees=employeeservice.getallemployees();
        return allemployees;
    }

    @PostMapping(path ="/update")
    public String updateemployee(@RequestBody employeeupdateDTO employeeupdateDTO) {
        String id = employeeservice.updateemployee(employeeupdateDTO);
        return id;
    }

    @DeleteMapping(path ="/deleteemployee/{id}")
    public String deleteemployee(@PathVariable(value="id") int id) {
        boolean deleteemployee = employeeservice.deleteemployee(id);
        return "deleted";
    }


}

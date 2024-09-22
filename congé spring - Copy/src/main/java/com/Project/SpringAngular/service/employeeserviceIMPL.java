package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.employeeDTO;
import com.Project.SpringAngular.DTO.employeesaveDTO;
import com.Project.SpringAngular.DTO.employeeupdateDTO;
import com.Project.SpringAngular.employeerepo.employeerepo;
import com.Project.SpringAngular.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class employeeserviceIMPL implements employeeservice{

    @Autowired
    private employeerepo employeerepo;
    @Override
    public String addemployee(employeesaveDTO employeesaveDTO) {
        employee e = new employee(
                employeesaveDTO.getNom(),
                employeesaveDTO.getPrenom(),
                employeesaveDTO.getEmail(),
                employeesaveDTO.getPassword(),
                employeesaveDTO.getDep(),
                employeesaveDTO.getRole()
        );

        employeerepo.save(e);
        return e.getPrenom();

    }

    @Override
    public List<employeeDTO> getallemployees() {
        List<employee> getemployees = employeerepo.findAll();
        List<employeeDTO> employeeDTOList = new ArrayList<>();
        for(employee i:getemployees){
            employeeDTO employeeDTO = new employeeDTO(
                i.getId(),
                i.getNom(),
                i.getPrenom(),
                i.getEmail(),
                    i.getPassword(),
                    i.getDe(),
                    i.getRole()
            );
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }



    @Override
    public String updateemployee(employeeupdateDTO employeeupdateDTO) {
        if (employeerepo.existsById(employeeupdateDTO.getId())){
            employee e = employeerepo.getById(employeeupdateDTO.getId());
            e.setNom(employeeupdateDTO.getNom());
            e.setPrenom(employeeupdateDTO.getPrenom());
            e.setEmail(employeeupdateDTO.getEmail());
            e.setDe(employeeupdateDTO.getDep());
            employeerepo.save(e);
        }

        else{
            System.out.println("employee don't exist");
        }

        return null;
    }

    @Override
    public boolean deleteemployee(int id) {

        if (employeerepo.existsById(id)){
            employeerepo.deleteById(id);
        }

        else System.out.println("no matching id found");

        return true;
    }
}

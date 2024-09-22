package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.departmentDTO;
import com.Project.SpringAngular.DTO.departmentsaveDTO;
import com.Project.SpringAngular.DTO.departmentupdateDTO;
import com.Project.SpringAngular.entity.department;
import com.Project.SpringAngular.departmentrepo.departmentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class departmentserviceIMPL implements departmentservice{

    @Autowired
    private departmentrepo departmentrepo;
    @Override
    public String adddepartment(departmentsaveDTO departmentsaveDTO) {
        department d = new department(
                departmentsaveDTO.getNom()
        );

        departmentrepo.save(d);
        return d.getnom();

    }

    @Override
    public List<departmentDTO> getalldepartments() {
        List<department> getdepartments = departmentrepo.findAll();
        List<departmentDTO> departmentDTOList = new ArrayList<>();
        for(department i:getdepartments){
            departmentDTO departmentDTO = new departmentDTO(
                    i.getId(),
                    i.getnom()
            );
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }



    @Override
    public String updatedepartment(departmentupdateDTO departmentupdateDTO) {
        if (departmentrepo.existsById(departmentupdateDTO.getId())){
            department d = departmentrepo.getById(departmentupdateDTO.getId());
            d.setnom(departmentupdateDTO.getNom());
            departmentrepo.save(d);
        }

        else{
            System.out.println("department don't exist");
        }

        return null;
    }

    @Override
    public boolean deletedepartment(int id) {

        if (departmentrepo.existsById(id)){
            departmentrepo.deleteById(id);
        }

        else System.out.println("no matching id found");

        return true;
    }
}

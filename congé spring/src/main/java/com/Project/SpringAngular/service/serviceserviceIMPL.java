package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.serviceDTO;
import com.Project.SpringAngular.DTO.servicesaveDTO;
import com.Project.SpringAngular.DTO.serviceupdateDTO;
import com.Project.SpringAngular.entity.service;
import com.Project.SpringAngular.servicerepo.servicerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceserviceIMPL implements serviceservice{

    @Autowired
    private servicerepo servicerepo;
    @Override
    public String addservice(servicesaveDTO servicesaveDTO) {
        service r = new service(
                servicesaveDTO.getNom()
        );

        servicerepo.save(r);
        return r.getNom();

    }

    @Override
    public List<serviceDTO> getallservices() {
        List<service> getservices = servicerepo.findAll();
        List<serviceDTO> serviceDTOList = new ArrayList<>();
        for(service i:getservices){
            serviceDTO serviceDTO = new serviceDTO(
                    i.getId(),
                    i.getNom()
            );
            serviceDTOList.add(serviceDTO);
        }
        return serviceDTOList;
    }



    @Override
    public String updateservice(serviceupdateDTO serviceupdateDTO) {
        if (servicerepo.existsById(serviceupdateDTO.getId())){
            service s = servicerepo.getById(serviceupdateDTO.getId());
            s.setNom(serviceupdateDTO.getNom());

            servicerepo.save(s);
        }

        else{
            System.out.println("service don't exist");
        }

        return null;
    }

    @Override
    public boolean deleteservice(int id) {

        if (servicerepo.existsById(id)){
            servicerepo.deleteById(id);
        }

        else System.out.println("no matching id found");

        return true;
    }
}

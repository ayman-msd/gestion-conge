package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.congeDTO;
import com.Project.SpringAngular.DTO.congesaveDTO;
import com.Project.SpringAngular.DTO.congeupdateDTO;
import com.Project.SpringAngular.entity.conge;
import com.Project.SpringAngular.congerepo.congerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class congeserviceIMPL implements congeservice{

    @Autowired
    private congerepo congerepo;
    @Override
    public String addconge(congesaveDTO congesaveDTO) {
        conge c = new conge(
                congesaveDTO.getNature(),
                congesaveDTO.getDate_d(),
                congesaveDTO.getDate_f(),                
                congesaveDTO.getDate_rep(),
                congesaveDTO.getEmp(),
                congesaveDTO.getEtat()

        );
        congerepo.save(c);
        return c.getNature();

    }

    @Override
    public List<congeDTO> getallconges() {
        List<conge> getconges = congerepo.findAll();
        List<congeDTO> congeDTOList = new ArrayList<>();
        for(conge i:getconges){
            congeDTO congeDTO = new congeDTO(
                i.getId(),
                i.getNature(),
                i.getDate_d(),
                    i.getDate_f(),                    
                    i.getDate_rep(),
                    i.getEmp(),
                    i.getEtat()
            );
            congeDTOList.add(congeDTO);
        }
        return congeDTOList;
    }



    @Override
    public String updateconge(congeupdateDTO congeupdateDTO) {
        if (congerepo.existsById(congeupdateDTO.getId())){
            conge c = congerepo.getById(congeupdateDTO.getId());
            c.setEtat(congeupdateDTO.getEtat());
            congerepo.save(c);
        }

        else{
            System.out.println("conge don't exist");
        }

        return null;
    }

    @Override
    public boolean deleteconge(int id) {

        if (congerepo.existsById(id)){
            congerepo.deleteById(id);
        }

        else System.out.println("no matching id found");

        return true;
    }
}

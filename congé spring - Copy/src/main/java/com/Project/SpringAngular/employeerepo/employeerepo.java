package com.Project.SpringAngular.employeerepo;

import com.Project.SpringAngular.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository


public interface employeerepo extends JpaRepository<employee,Integer> {

}

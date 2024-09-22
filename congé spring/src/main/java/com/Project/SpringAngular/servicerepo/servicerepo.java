package com.Project.SpringAngular.servicerepo;

import com.Project.SpringAngular.entity.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository

public interface servicerepo extends JpaRepository<service,Integer> {

}

package com.Project.SpringAngular.congerepo;

import com.Project.SpringAngular.entity.conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository


public interface congerepo extends JpaRepository<conge,Integer> {

}

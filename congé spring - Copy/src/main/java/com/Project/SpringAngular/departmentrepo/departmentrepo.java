package com.Project.SpringAngular.departmentrepo;

import com.Project.SpringAngular.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository


public interface departmentrepo extends JpaRepository<department,Integer> {
}

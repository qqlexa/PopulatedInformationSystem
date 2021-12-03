package com.kpi.hlavatskyi.informationsystem.repository;

import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    boolean existsByNameAndDate(String name, Date date);

}

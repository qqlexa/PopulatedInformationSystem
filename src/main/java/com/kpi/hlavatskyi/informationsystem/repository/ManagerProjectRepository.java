package com.kpi.hlavatskyi.informationsystem.repository;

import com.kpi.hlavatskyi.informationsystem.entity.ManagerProjectEntity;
import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerProjectRepository extends CrudRepository<ManagerProjectEntity, Long> {

    boolean existsByProject(ProjectEntity project);

}

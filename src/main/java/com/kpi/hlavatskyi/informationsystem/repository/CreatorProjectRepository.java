package com.kpi.hlavatskyi.informationsystem.repository;

import com.kpi.hlavatskyi.informationsystem.entity.CreatorProjectEntity;
import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorProjectRepository extends CrudRepository<CreatorProjectEntity, Long> {

    boolean existsByProject(ProjectEntity project);

}

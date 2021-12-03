package com.kpi.hlavatskyi.informationsystem.repository;

import com.kpi.hlavatskyi.informationsystem.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);

}

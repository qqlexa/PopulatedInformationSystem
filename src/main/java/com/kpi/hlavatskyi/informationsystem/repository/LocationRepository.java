package com.kpi.hlavatskyi.informationsystem.repository;

import com.kpi.hlavatskyi.informationsystem.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity, Long> {

}

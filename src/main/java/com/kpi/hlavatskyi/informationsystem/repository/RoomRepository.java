package com.kpi.hlavatskyi.informationsystem.repository;

import com.kpi.hlavatskyi.informationsystem.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

    boolean existsByName(String name);

}

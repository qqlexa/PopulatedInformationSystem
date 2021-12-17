package com.kpi.hlavatskyi.informationsystem.patterns.factory.dao;

import java.util.List;

public interface AbstractDAO<K, E> {

    List<E> getAll();

    boolean update(E entity);

    boolean delete(K k);

    boolean create(E entity);

    E getById(K k);

}

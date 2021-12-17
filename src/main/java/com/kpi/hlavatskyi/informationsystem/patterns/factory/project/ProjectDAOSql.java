package com.kpi.hlavatskyi.informationsystem.patterns.factory.project;

import java.sql.Connection;
import java.util.List;

public class ProjectDAOSql implements ProjectDAO<Long> {

    private Connection connection;

    public ProjectDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public boolean update(Project entity) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean create(Project entity) {
        return false;
    }

    @Override
    public Project getById(Long aLong) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDAOSql)) return false;
        ProjectDAOSql that = (ProjectDAOSql) o;
        return connection.equals(that.connection);
    }

}

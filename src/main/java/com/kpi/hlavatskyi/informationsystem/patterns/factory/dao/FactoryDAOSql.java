package com.kpi.hlavatskyi.informationsystem.patterns.factory.dao;

import com.kpi.hlavatskyi.informationsystem.patterns.factory.project.ProjectDAO;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.project.ProjectDAOSql;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.user.UserDAO;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.user.UserDAOSql;

import java.sql.Connection;

public class FactoryDAOSql implements FactoryDAO {

    @Override
    public UserDAO createUserDAO(Connection connection) {
        return new UserDAOSql(connection);
    }

    @Override
    public ProjectDAO createProjectDAO(Connection connection) {
        return new ProjectDAOSql(connection);
    }

}

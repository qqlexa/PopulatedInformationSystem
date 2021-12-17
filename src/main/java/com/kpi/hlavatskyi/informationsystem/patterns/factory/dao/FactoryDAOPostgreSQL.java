package com.kpi.hlavatskyi.informationsystem.patterns.factory.dao;

import com.kpi.hlavatskyi.informationsystem.patterns.factory.project.ProjectDAO;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.project.ProjectDAOPostgreSQL;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.user.UserDAO;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.user.UserDAOPostgreSQL;

import java.sql.Connection;

public class FactoryDAOPostgreSQL implements FactoryDAO {

    @Override
    public UserDAO createUserDAO(Connection connection) {
        return new UserDAOPostgreSQL(connection);
    }

    @Override
    public ProjectDAO createProjectDAO(Connection connection) {
        return new ProjectDAOPostgreSQL(connection);
    }

}

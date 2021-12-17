package com.kpi.hlavatskyi.informationsystem.patterns.factory.dao;

import com.kpi.hlavatskyi.informationsystem.patterns.factory.project.ProjectDAO;
import com.kpi.hlavatskyi.informationsystem.patterns.factory.user.UserDAO;

import java.sql.Connection;

public interface FactoryDAO {

    UserDAO createUserDAO(Connection connection);
    ProjectDAO createProjectDAO(Connection connection);

}

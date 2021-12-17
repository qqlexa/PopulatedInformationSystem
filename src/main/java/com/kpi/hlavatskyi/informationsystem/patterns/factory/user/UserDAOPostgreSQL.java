package com.kpi.hlavatskyi.informationsystem.patterns.factory.user;

import java.sql.Connection;
import java.util.List;

public class UserDAOPostgreSQL implements UserDAO {

    private Connection connection;

    public UserDAOPostgreSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean update(Object entity) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object getById(Object o) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDAOPostgreSQL)) return false;
        UserDAOPostgreSQL that = (UserDAOPostgreSQL) o;
        return connection.equals(that.connection);
    }
}

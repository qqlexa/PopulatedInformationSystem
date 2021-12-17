package com.kpi.hlavatskyi.informationsystem.patterns.factory.user;

import java.sql.Connection;
import java.util.List;

public class UserDAOSql implements UserDAO<Long> {

    private Connection connection;

    public UserDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User getById(Long aLong) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDAOSql)) return false;
        UserDAOSql that = (UserDAOSql) o;
        return connection.equals(that.connection);
    }

}

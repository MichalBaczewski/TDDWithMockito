package com.mbaczewski.main;

import com.sun.rowset.JdbcRowSetImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserService {

    static final ResultSet EMPTY_SET = new JdbcRowSetImpl();

    private Connection sqlConnection;

    public UserService(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ResultSet queryUsers(String where) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = sqlConnection.prepareStatement(where);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            return EMPTY_SET;
        }
    }

    public boolean updateUser(User user) throws SQLException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = sqlConnection.prepareStatement(user.updateStatement());
            return preparedStatement.executeUpdate() > 1;
        } catch (SQLException e) {
            throw e;
        }
    }

}

package services.impl;

import models.User;
import play.db.DB;
import utils.SqlWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by saravmalar on 8/2/15.
 */
public class UserServiceSqlWrapper {

    private static final Connection connection = DB.getConnection();

    private static final UserServiceSqlWrapper INSTANCE = new UserServiceSqlWrapper();

    private UserServiceSqlWrapper() {
        //Utility method
    }

    public static UserServiceSqlWrapper getInstance() {
        return INSTANCE;
    }

    public void createUserInDb(String sql, User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setDate(6, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(7, user.getGender());
            preparedStatement.setDate(8, new java.sql.Date(user.getJoinDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

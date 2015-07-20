package services.impl;

import models.User;
import services.UserService;
import utils.SqlQueries;
import utils.SqlWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by saravmalar on 7/19/15.
 */
public class UserServiceImpl implements UserService {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String JOIN_DATE = "joinDate";
    private static final String PASSWORD = "password";
    private static final String GENDER = "gender";
    private static final String DOB = "dob";
    private static final String USER_NAME = "userName";
    private static final String USER_ID = "userId";
    private static final String USER_EMAIL = "email";

    @Override
    public List<User> getUsers() {
        String sql = SqlQueries.getInstance().getQuery("GetAllUsers");
        SqlWrapper sqlWrapper = new SqlWrapper();
        try {
            ResultSet resultSet = sqlWrapper.getMultipleData(sql);
            List<Map<String, Object>> usersList = SqlWrapper.convertToObjects(resultSet);
            return convertToUserObjects(usersList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<User> convertToUserObjects(List<Map<String, Object>> usersList) {
        List<User> users = new ArrayList<>();
        for (Map<String, Object> user: usersList) {
            User modelUser = new User();
            modelUser.setFirstName((String)user.get(FIRST_NAME));
            modelUser.setLastName((String)user.get(LAST_NAME));
            modelUser.setJoinDate((Date)user.get(JOIN_DATE));
            modelUser.setGender((String)user.get(GENDER));
            modelUser.setDob((Date)user.get(DOB));
            modelUser.setUserName((String)user.get(USER_NAME));
            modelUser.setEmail((String)user.get(USER_EMAIL));
            modelUser.setPassword("***");
            users.add(modelUser);
        }
        return users;
    }
}

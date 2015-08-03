package services.impl;

import models.User;
import play.mvc.Http;
import services.UserService;
import utils.SqlQueries;
import utils.SqlWrapper;

import javax.xml.ws.http.HTTPException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    @Override
    public User getUser(String userId) {
        String sql = SqlQueries.getInstance().getQuery("GetUser", userId);
        SqlWrapper sqlWrapper = new SqlWrapper();
        try {
            ResultSet resultSet = sqlWrapper.getSingleData(sql);
            Map<String, Object> user = SqlWrapper.convertToObject(resultSet);
            return convertToUserObject(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User createUser(User user) {
        //Validate whether the user already exists.
        User rtvdUser = getUser(user.getEmail());
        if (rtvdUser != null && rtvdUser.getEmail().equals(user.getEmail())) {// throw exception.
            throw new HTTPException(Http.Status.CONFLICT);
        }
        Date joiningDate = Calendar.getInstance().getTime();
        user.setJoinDate(joiningDate);
        String sql = SqlQueries.getInstance().getQuery("CreateUser");
        System.out.println("sql query = " + sql);
        UserServiceSqlWrapper sqlWrapper = new UserServiceSqlWrapper();
        sqlWrapper.createUserInDb(sql, user);
        return getUser(user.getEmail());

    }

    private User convertToUserObject(Map<String, Object> user) {
        User modelUser = new User();
        if (user != null && !user.isEmpty()) {
            modelUser.setUserId((Integer) user.get(USER_ID));
            modelUser.setFirstName((String) user.get(FIRST_NAME));
            modelUser.setLastName((String) user.get(LAST_NAME));
            modelUser.setJoinDate((Date) user.get(JOIN_DATE));
            modelUser.setGender((String) user.get(GENDER));
            modelUser.setDob((Date) user.get(DOB));
            modelUser.setUserName((String) user.get(USER_NAME));
            modelUser.setEmail((String) user.get(USER_EMAIL));
            modelUser.setPassword("***");
            return modelUser;
        }
        return null;

    }

    private List<User> convertToUserObjects(List<Map<String, Object>> usersList) {
        List<User> users = new ArrayList<>();
        for (Map<String, Object> user: usersList) {
            users.add(convertToUserObject(user));
        }
        return users;
    }

}

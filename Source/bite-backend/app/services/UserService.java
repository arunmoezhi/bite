package services;

import models.User;

import java.util.List;

/**
 * Created by saravmalar on 7/19/15.
 */
public interface UserService {



    public List<User> getUsers();

    public User getUser(String userId);
}

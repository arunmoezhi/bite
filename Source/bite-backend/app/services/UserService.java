package services;

import models.User;

public interface UserService {

    public void addUser(User user);
    public User getUser(String  userId);
    public User getUser(String userName, String password);
}
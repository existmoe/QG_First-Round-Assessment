package service;

import dao.UserDAO;
import pojo.User;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {
        User user = userDAO.getUserByUserName(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean register(User user) {
        try {
            return userDAO.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
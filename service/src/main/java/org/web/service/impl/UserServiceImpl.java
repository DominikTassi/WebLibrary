package org.web.service.impl;
import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;
import org.web.core.service.UserService;
import org.web.service.dao.UserDAO;

import java.sql.SQLException;
import java.util.Collection;

public class UserServiceImpl implements UserService{
    private UserDAO userDAO = null;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser(User user) throws NoUserException, SQLException {
        return userDAO.getUser(user);
    }

    public User getUser(int id) throws NoUserException, SQLException {
        return userDAO.getUser(id);
    }

    public Collection<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }


    public boolean deleteUser(User user) {
        return userDAO.deleteUser(user);
    }

    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }
}

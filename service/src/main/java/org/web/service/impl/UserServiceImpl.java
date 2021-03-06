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

    public User getUser(String user) throws NoUserException, SQLException {
        return userDAO.getUser(user);
    }

    public User getUser(int id) throws NoUserException, SQLException {
        return userDAO.getUser(id);
    }

    public Collection<User> getAllUser() throws SQLException {
        return userDAO.getAllUser();
    }

    public void addUser(String userName, String password) {
        userDAO.addUser(userName,password);
    }


    public boolean deleteUser(String userName) throws SQLException {
        return userDAO.deleteUser(userName);
    }

    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }
}

package org.web.core.service;

import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserService {
    public User getUser(String user) throws NoUserException, SQLException;
    public User getUser(int id) throws NoUserException, SQLException;

    public Collection<User> getAllUser() throws SQLException;
    public void addUser(String userName, String password);

    public boolean deleteUser(String userName) throws SQLException;
    public boolean deleteUser(int id) throws SQLException;
}

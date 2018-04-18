package org.web.service.dao;

import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserDAO {
    public User getUser(String user) throws NoUserException;
    public User getUser(int id) throws NoUserException, SQLException;

    public Collection<User> getAllUser() throws SQLException;
    public void addUser(String userName, String password);

    public boolean deleteUser(String userName) throws SQLException;
    public boolean deleteUser(int id) throws SQLException;
}

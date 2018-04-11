package org.web.service.dao;

import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserDAO {
    public User getUser(User user) throws NoUserException;
    public User getUser(int id) throws NoUserException, SQLException;

    public Collection<User> getAllUser() throws SQLException;
    public void addUser(User user);

    public boolean deleteUser(User user) throws SQLException;
    public boolean deleteUser(int id) throws SQLException;
}

package org.web.org.web.service.dao;

import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;

import java.util.Collection;

public interface UserDAO {
    public User getUser(User user) throws NoUserException;
    public User getUser(int id) throws NoUserException;

    public Collection<User> getAllUser();
    public void addUser(User user);
    public void addUser(String name);

    public boolean deleteUser(User user);
    public boolean deleteUser(int id);
}

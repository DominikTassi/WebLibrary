package org.web.core.model;

import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPasswordException;

public class User {
    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password) throws NoNameException, NoPasswordException {
        this.id = id;
        setName(name);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NoNameException {
        if(name == null || name == "")
            throw new NoNameException("No name was given");
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoPasswordException {
        if (password == null || password == "")
            throw new NoPasswordException("No password was given");
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}

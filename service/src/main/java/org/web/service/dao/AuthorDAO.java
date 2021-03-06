package org.web.service.dao;

import org.web.core.exceptions.NoAuthorException;
import org.web.core.exceptions.NoNameException;
import org.web.core.model.Author;

import java.sql.SQLException;
import java.util.Collection;

public interface AuthorDAO {

    public void addAuthor(String authorName, String authorBirthDate, String authorNationality) throws NoAuthorException;
    public Author getAuthor(int id) throws NoAuthorException;
    public Author getAuthor(String name) throws NoAuthorException, NoNameException;
    public Collection<Author> getAllAuthor() throws SQLException;
}

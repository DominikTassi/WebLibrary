package org.web.service.impl;
import org.web.core.exceptions.NoAuthorException;
import org.web.core.exceptions.NoNameException;
import org.web.core.model.Author;
import org.web.core.service.AuthorService;
import org.web.service.dao.AuthorDAO;

import java.sql.SQLException;
import java.util.Collection;


public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO = null;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public void addAuthor(String authorName, String authorBirthDate, String authorNationality) throws NoAuthorException {
        authorDAO.addAuthor(authorName, authorNationality, authorBirthDate);
    }

    public Author getAuthor(int id) throws NoAuthorException {
        return authorDAO.getAuthor(id);
    }

    public Author getAuthor(String name) throws NoAuthorException, NoNameException {
        return authorDAO.getAuthor(name);
    }

    public Collection<Author> getAllAuthor() throws SQLException {
        return authorDAO.getAllAuthor();
    }
}

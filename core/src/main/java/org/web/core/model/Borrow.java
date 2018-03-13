package org.web.core.model;

import org.web.core.exceptions.NoBooksException;
import org.web.core.exceptions.NoUserException;

import java.util.Collection;
import java.util.Date;

public class Borrow {
    private int id;
    private Collection<Book> books;
    private User user;
    private Date date;

    public Borrow(int id, Collection<Book> books, User user) throws NoBooksException, NoUserException {
        this.id = id;
        setBooks(books);
        setUser(user);
        date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) throws NoBooksException {
        if (books == null || books.isEmpty())
            throw new NoBooksException("No books was given");
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) throws NoUserException {
        if (user == null)
            throw new NoUserException("No user was given");
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package org.web.core;

import java.util.Collection;
import java.util.Date;

public class Borrow {
    private int id;
    private Collection<Book> books;
    private User user;
    private Date date;

    public Borrow(int id, Collection<Book> books, User user) {
        this.id = id;
        this.books = books;
        this.user = user;
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

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package org.web.service.dao;

import org.web.core.exceptions.NoBorrowException;
import org.web.core.model.Book;
import org.web.core.model.Borrow;

import java.util.Collection;

public interface BorrowDAO {

    public Borrow getBorrow(int id) throws NoBorrowException;
    public Borrow getBorrow(Borrow borrow) throws NoBorrowException;
    public Collection<Borrow> getAllBorrow() throws NoBorrowException;

    public Collection<Book> getBorrowedBooksById(int id) throws NoBorrowException;
    public void addBorrow(Borrow borrow);
}

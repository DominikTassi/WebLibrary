package org.web.core.service;

import org.web.core.model.Book;
import org.web.core.model.Borrow;

import java.util.Collection;

public interface BorrowService {

    public Borrow getBorrow(int id);
    public Borrow getBorrow(Borrow borrow);
    public Collection<Borrow> getAllBorrow();

    public Collection<Book> getBorrowedBookById(int id);
    public void addBorrow(Borrow borrow);
}

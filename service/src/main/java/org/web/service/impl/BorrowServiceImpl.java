package org.web.service.impl;


import org.web.core.exceptions.NoBorrowException;
import org.web.core.model.Book;
import org.web.core.model.Borrow;
import org.web.core.service.BorrowService;
import org.web.service.dao.BorrowDAO;

import java.util.Collection;

public class BorrowServiceImpl implements BorrowService {
    private BorrowDAO borrowDAO = null;

    public BorrowServiceImpl(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    public Borrow getBorrow(int id) throws NoBorrowException {
        return borrowDAO.getBorrow(id);
    }

    public Borrow getBorrow(Borrow borrow) throws NoBorrowException {
        return borrowDAO.getBorrow(borrow);
    }

    public Collection<Borrow> getAllBorrow() throws NoBorrowException {
        return borrowDAO.getAllBorrow();
    }

    public Collection<Book> getBorrowedBooksById(int id) throws NoBorrowException {
        return borrowDAO.getBorrowedBooksById(id);
    }

    public void addBorrow(Borrow borrow) {
        borrowDAO.addBorrow(borrow);
    }
}

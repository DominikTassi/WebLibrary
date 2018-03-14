package org.web.service.impl;
import org.web.core.exceptions.*;
import org.web.core.model.*;
import org.web.core.service.BookService;
import org.web.service.dao.BookDAO;

import java.util.Collection;
import java.util.Date;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = null;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Book getBookByISBN(int ISBN) throws WrongISBNException {
        return bookDAO.getBookByISBN(ISBN);
    }

    public Collection<Book> getBooksByName(String name) throws NoNameException {
        return bookDAO.getBooksByName(name);
    }

    public Collection<Book> getBooksBySubject(Subject subject) throws NoSubjectException {
        return getBooksBySubject(subject);
    }

    public Collection<Book> getBooksByAuthor(Author author) throws NoAuthorException {
        return getBooksByAuthor(author);
    }

    public Collection<Book> getBooksByPublisher(Publisher publisher) throws NoPublisherException {
        return getBooksByPublisher(publisher);
    }

    public Collection<Book> getBooksByLanguage(Nationality language) {
        return getBooksByLanguage(language);
    }

    public Collection<Book> getBooksByPrice(int price) throws WrongPriceException {
        return getBooksByPrice(price);
    }

    public Collection<Book> getAllBook() {
        return bookDAO.getAllBook();
    }

    public Collection<Book> getBooksByYear(Date date) {
        return bookDAO.getBooksByYear(date);
    }

    public void addBook(Book book) throws NoBookException {
        bookDAO.addBook(book);
    }

    public boolean deleteBook(int id) throws NoBookException {
        return bookDAO.deleteBook(id);
    }

    public boolean deleteBook(Book book) throws NoBookException {
        return bookDAO.deleteBook(book);
    }

    public Collection<Book> getCheaperBooksThanPrice(int price) {
        return bookDAO.getCheaperBooksThanPrice(price);
    }
}

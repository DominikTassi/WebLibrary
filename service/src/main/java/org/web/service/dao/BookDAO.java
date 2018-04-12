package org.web.service.dao;

import org.web.core.exceptions.*;
import org.web.core.model.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface BookDAO {
    public Book getBookByISBN(int ISBN) throws WrongISBNException;
    public Collection<Book> getBooksByName(String name) throws NoNameException;
    public Collection<Book> getBooksBySubject(Subject subject) throws NoSubjectException;
    public Collection<Book> getBooksByAuthor(Author author) throws NoAuthorException;
    public Collection<Book> getBooksByPublisher(Publisher publisher) throws NoPublisherException;
    public Collection<Book> getBooksByLanguage(Nationality language);
    public Collection<Book> getBooksByPrice(int price) throws WrongPriceException;
    public Collection<Book> getAllBook();
    public Collection<Book> getBooksByYear(Date date);

    public void addBook(Book book) throws NoBookException;
    public boolean deleteBook(int id) throws NoBookException, SQLException;
    public boolean deleteBook(Book book) throws NoBookException, SQLException;

    public Collection<Book> getCheaperBooksThanPrice(int price);
}

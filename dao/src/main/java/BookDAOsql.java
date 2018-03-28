import org.web.core.exceptions.*;
import org.web.core.model.*;
import org.web.service.dao.BookDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;

public class BookDAOsql extends DataBaseInit implements BookDAO {

    private Connection connection = openConnection();

    private Statement statement;

    public BookDAOsql() throws SQLException, ClassNotFoundException {
    }

    @Override
    public Book getBookByISBN(int ISBN) throws WrongISBNException {
        return null;
    }

    @Override
    public Collection<Book> getBooksBySubject(Subject subject) throws NoSubjectException {
        return null;
    }

    @Override
    public Collection<Book> getBooksByAuthor(Author author) throws NoAuthorException {
        return null;
    }

    @Override
    public Collection<Book> getBooksByPublisher(Publisher publisher) throws NoPublisherException {
        return null;
    }

    @Override
    public Collection<Book> getBooksByLanguage(Nationality language) {
        return null;
    }

    @Override
    public Collection<Book> getBooksByPrice(int price) throws WrongPriceException {
        return null;
    }

    @Override
    public Collection<Book> getAllBook() {
        return null;
    }

    @Override
    public Collection<Book> getBooksByYear(Date date) {
        return null;
    }

    @Override
    public void addBook(Book book) throws NoBookException {

    }

    @Override
    public boolean deleteBook(int id) throws NoBookException {
        return false;
    }

    @Override
    public boolean deleteBook(Book book) throws NoBookException {
        return false;
    }

    @Override
    public Collection<Book> getCheaperBooksThanPrice(int price) {
        return null;
    }

    @Override
    public Collection<Book> getBooksByName(String name) throws NoNameException {
        return null;
    }
}

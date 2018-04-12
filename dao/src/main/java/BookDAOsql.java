import org.web.core.exceptions.*;
import org.web.core.model.*;
import org.web.service.dao.BookDAO;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Collection;
import java.util.Date;

public class BookDAOsql extends DataBaseInit implements BookDAO {

    private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    public BookDAOsql() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }

    @Override
    public Book getBookByISBN(int ISBN) throws WrongISBNException {
        Book book = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int localISBN = 0;
            String name = null;
            Subject subject = null;
            Author author = null;
            int price = 0;
            Publisher publisher = null;
            Date publicationDate = null;
            Nationality language = null;

            String sql = "SELECT * FROM Book WHERE ISBN = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ISBN);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                localISBN = rs.getInt("ISBN");
                name = rs.getString("Name");
                subject.setId(rs.getInt("Id"));
                subject.setName(rs.getString("Name"));
                author.setId(rs.getInt("Id"));
                author.setName(rs.getString("Name"));
                author.setBirth(rs.getDate("Birth"));
                author.setNationality(Nationality.valueOf(rs.getString("Nationality")));
                price = rs.getInt("Price");
                publisher.setId(rs.getInt("Id"));
                publisher.setName("Name");
                publicationDate = rs.getDate("PublicationDate");
                language = Nationality.valueOf(rs.getString("Language"));
            }
            book = new Book(localISBN, name, subject,author, price ,publisher,publicationDate,language);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } catch (NoSubjectException e) {
            e.printStackTrace();
        } catch (NoPublicationDateException e) {
            e.printStackTrace();
        } catch (NoPublisherException e) {
            e.printStackTrace();
        } catch (NoAuthorException e) {
            e.printStackTrace();
        } catch (WrongPriceException e) {
            e.printStackTrace();
        } catch (NoBirthDateException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
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

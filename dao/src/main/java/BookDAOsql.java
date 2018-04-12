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
        Subject subject = null;
        Author author = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int localISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int price = 0;
            int publisherId = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE ISBN = ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setInt(1, ISBN);
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                localISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));
            }


            String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
            PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
            psSubject.setInt(1, subjectId);
            ResultSet rsSubject = psSubject.executeQuery();
            if(rsSubject.next()){
                subject.setId(rsSubject.getInt("SubjectId"));
                subject.setName(rsSubject.getString("SubjectName"));
            }


            String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
            PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
            psAuthor.setInt(1, authorId);
            ResultSet rsAuthor = psAuthor.executeQuery();
            if(rsAuthor.next()){
                author.setId(rsAuthor.getInt("AuthorId"));
                author.setName(rsAuthor.getString("AuthorName"));
                author.setBirth(rsAuthor.getDate("AuthorBith"));
                author.setNationality(Nationality.valueOf(rsAuthor.getString("Nationality")));
            }


            String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
            PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
            psPublisher.setInt(1, publisherId);
            ResultSet rsPublisher = psPublisher.executeQuery();
            if(rsPublisher.next()){
                publisher.setId(rsPublisher.getInt("PublisherId"));
                publisher.setName(rsPublisher.getString("PublisherName"));
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

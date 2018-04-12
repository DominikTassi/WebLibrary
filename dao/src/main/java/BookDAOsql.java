import org.web.core.exceptions.*;
import org.web.core.model.*;
import org.web.service.dao.BookDAO;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
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
                subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
            }


            String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
            PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
            psAuthor.setInt(1, authorId);
            ResultSet rsAuthor = psAuthor.executeQuery();
            if(rsAuthor.next()){
                author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
            }


            String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
            PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
            psPublisher.setInt(1, publisherId);
            ResultSet rsPublisher = psPublisher.executeQuery();
            if(rsPublisher.next()){
                publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
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
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int price = 0;
            int publisherId = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE SubjectId = ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setInt(1, subject.getId());
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getBooksByAuthor(Author author) throws NoAuthorException {
        Collection<Book> books = new ArrayList<>();
        Subject subject = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int price = 0;
            int publisherId = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE AuthorId = ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setInt(1, author.getId());
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getBooksByPublisher(Publisher publisher) throws NoPublisherException {
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Subject subject = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int price = 0;
            int publisherId = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE PublisherId = ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setInt(1, publisher.getId());
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getBooksByLanguage(Nationality language) {
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Subject subject = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int price = 0;
            int publisherId = 0;
            Date publicationDate = null;

            String sqlBook = "SELECT * FROM Book WHERE BookLanguage = ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setString(1, String.valueOf(language));
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getBooksByPrice(int price) throws WrongPriceException {
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Subject subject = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int publisherId = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE BookPrice >= ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setInt(1, price);
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getAllBook() {
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Subject subject = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int publisherId = 0;
            int price = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getBooksByYear(Date date) {
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Subject subject = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int publisherId = 0;
            int price = 0;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE PublicationDate = ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setDate(1, (java.sql.Date) date);
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                date = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,date,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public void addBook(Book book) throws NoBookException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Book (ISBN, BookName, SubjectId, AuthorId, BookPrice, PublisherId, BookPublicationDate, BookLanguage ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, book.getISBN());
            ps.setString(2,book.getName());
            ps.setInt(3, book.getSubject().getId());
            ps.setInt(4, book.getAuthor().getId());
            ps.setInt(5, book.getPrice());
            ps.setInt(6, book.getPublisher().getId());
            ps.setDate(7, (java.sql.Date) book.getPublicationDate());
            ps.setString(8,String.valueOf(book.getLanguage()));
            ps.executeUpdate();
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    @Override
    public boolean deleteBook(int id) throws NoBookException, SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "DELETE FROM Book WHERE ISBN = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            return true;
        }
    }

    @Override
    public boolean deleteBook(Book book) throws NoBookException, SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "DELETE FROM Book WHERE ISBN = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, book.getISBN());
            ps.executeUpdate();
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            return true;
        }
    }

    @Override
    public Collection<Book> getCheaperBooksThanPrice(int price) {
        Collection<Book> books = new ArrayList<>();
        Author author = null;
        Subject subject = null;
        Publisher publisher = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int ISBN = 0;
            String name = null;
            int subjectId = 0;
            int authorId = 0;
            int publisherId = 0;
            Date publicationDate = null;
            Nationality language = null;

            String sqlBook = "SELECT * FROM Book WHERE BookPrice <= ?";
            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setInt(1, price);
            ResultSet rsBook = psBook.executeQuery();
            if(rsBook.next()){
                ISBN = rsBook.getInt("ISBN");
                name = rsBook.getString("BookName");
                subjectId = rsBook.getInt("SubjectId");
                authorId = rsBook.getInt("AuthorId");
                price = rsBook.getInt("BookPrice");
                publisherId = rsBook.getInt("PublisherId");
                publicationDate = rsBook.getDate("BookPublicationDate");
                language = Nationality.valueOf(rsBook.getString("BookLanguage"));


                String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = ?";
                PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
                psSubject.setInt(1, subjectId);
                ResultSet rsSubject = psSubject.executeQuery();
                if(rsSubject.next()){
                    subject = new Subject(rsSubject.getInt("SubjectId"), rsSubject.getString("SubjectName"));
                }


                String sqlAuthor = "SELECT * FROM Author WHERE AuthorId = ?";
                PreparedStatement psAuthor = connection.prepareStatement(sqlAuthor);
                psAuthor.setInt(1, authorId);
                ResultSet rsAuthor = psAuthor.executeQuery();
                if(rsAuthor.next()){
                    author = new Author(rsAuthor.getInt("AuthorId"), rsAuthor.getString("AuthorName"), rsAuthor.getDate("AuthorBirth"), Nationality.valueOf(rsAuthor.getString("Nationality")));
                }


                String sqlPublisher = "SELECT * FROM Publisher WHERE PublisherId = ?";
                PreparedStatement psPublisher = connection.prepareStatement(sqlPublisher);
                psPublisher.setInt(1, publisherId);
                ResultSet rsPublisher = psPublisher.executeQuery();
                if(rsPublisher.next()){
                    publisher = new Publisher(rsPublisher.getInt("PublisherId"), rsPublisher.getString("PublisherName"));
                }


                books.add(new Book(ISBN, name, subject,author, price ,publisher,publicationDate,language));
            }

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
        } catch (WrongISBNException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Collection<Book> getBooksByName(String name) throws NoNameException {
        return null;
    }
}

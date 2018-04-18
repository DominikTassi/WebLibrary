import org.web.core.exceptions.NoAuthorException;
import org.web.core.exceptions.NoBirthDateException;
import org.web.core.exceptions.NoNameException;
import org.web.core.model.Author;
import org.web.core.model.Nationality;
import org.web.service.dao.AuthorDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class AuthorDAOsql extends DataBaseInit implements AuthorDAO {

    private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    public AuthorDAOsql() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }

    @Override
    public void addAuthor(String authorName, String authorbirthDate, String authorNationality) throws NoAuthorException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Author (AuthorName, AuthorBirth,Nationality) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, authorName);
            ps.setString(2, authorbirthDate);
            ps.setString(3, authorNationality);
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
    public Author getAuthor(int id) throws NoAuthorException {
        Author author = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int authorId = 0;
            String name = null;
            Date birth = null;
            Nationality nationality = null;


            String sql = "SELECT * FROM User WHERE AuthorId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                authorId = rs.getInt("AuthorId");
                name = rs.getString("AuthorName");
                birth = rs.getDate("AuthorBith");
                nationality = Nationality.valueOf(rs.getString("Nationality"));
            }
            author = new Author(authorId, name, birth, nationality);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
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
        return author;
    }

    @Override
    public Author getAuthor(String name) throws NoAuthorException, NoNameException {
        Author author = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int authorId = 0;
            String authirName = null;
            Date birth = null;
            Nationality nationality = null;


            String sql = "SELECT * FROM User WHERE AuthorName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                authorId = rs.getInt("AuthorId");
                authirName = rs.getString("AuthorName");
                birth = rs.getDate("AuthorBirth");
                nationality = Nationality.valueOf(rs.getString("Nationality"));
            }
            author = new Author(authorId, authirName, birth, nationality);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
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
        return author;
    }

    @Override
    public Collection<Author> getAllAuthor() throws SQLException {
        Collection<Author> authors = new ArrayList<>();
        try{
            int id = 0;
            String name = null;
            Date birth = null;
            Nationality nationality = null;

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM Author";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("AuthorId");
                name = rs.getString("AuthorName");
                birth = rs.getDate("AuthorBirth");
                nationality = Nationality.valueOf(rs.getString("Nationality"));
                authors.add(new Author(id, name, birth, nationality));
            }
            rs.close();
            ps.close();
        }
        finally {
            connection.close();
            return authors;
        }
    }
}

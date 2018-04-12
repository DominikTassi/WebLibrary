import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPublisherException;
import org.web.core.model.Book;
import org.web.core.model.Publisher;
import org.web.core.model.User;
import org.web.service.dao.PublisherDAO;

import java.sql.*;
import java.util.Collection;

public class PublisherDAOSql extends DataBaseInit implements PublisherDAO{

    private Connection connection = openConnection();
    private String url = DataBaseInit.url;
    private Publisher publisher = null;

    public PublisherDAOSql() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }

    @Override
    public Publisher getPublisher(int id) throws NoPublisherException, SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int publisherId = 0;
            String publisherName = null;

            String sql = "SELECT FROM Publisher WHERE PublisherId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                publisherId = rs.getInt("PublisherId");
                publisherName = rs.getString("PublisherName");
            }
            publisher = new Publisher(publisherId, publisherName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            return publisher;
        }
    }

    @Override
    public Publisher getPublisher(Publisher publisher) throws NoPublisherException, SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int publisherId = 0;
            String publisherName = null;

            String sql = "SELECT FROM Publisher WHERE PublisherId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, publisher.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                publisherId = rs.getInt("PublisherId");
                publisherName = rs.getString("PublisherName");
            }
            publisher = new Publisher(publisherId, publisherName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            return publisher;
        }
    }

    @Override
    public void addPublisher(Publisher publisher) throws SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Publisher (PublisherId, PublisherName) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, publisher.getId());
            ps.setString(2, publisher.getName());
            ps.executeUpdate();
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public Collection<Book> getAllPublisher() {
        return null;
    }
}

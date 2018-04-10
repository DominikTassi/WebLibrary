import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPasswordException;
import org.web.core.exceptions.NoUserException;
import org.web.core.exceptions.NotFoundException;
import org.web.core.model.User;
import org.web.service.dao.UserDAO;

import java.sql.*;
import java.util.Collection;

public class UserDAOSql extends DataBaseInit implements UserDAO{

    private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    public UserDAOSql() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }

    @Override
    public User getUser(User user) throws NoUserException {
        return null;
    }

    @Override
    public User getUser(int id) throws NoUserException, SQLException {
        User user = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int userId = 0;
            String name = null;
            String password = null;


            String sql = "SELECT * FROM User WHERE UserId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userId = rs.getInt("UserId");
                name = rs.getString("Name");
                password = rs.getString("Password");
            }
            user = new User(userId, name, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoPasswordException e) {
            e.printStackTrace();
        } catch (NoNameException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public Collection<User> getAllUser() {
        return null;
    }

    @Override
    public void addUser(User user) {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO User (UserId, Name, Password) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
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
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}

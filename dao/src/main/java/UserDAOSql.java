import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPasswordException;
import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;
import org.web.service.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserDAOSql extends DataBaseInit implements UserDAO{

    private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    public UserDAOSql() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }

    @Override
    public User getUser(User user) throws NoUserException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int userId = 0;
            String name = null;
            String password = null;


            String sql = "SELECT * FROM User WHERE UserId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userId = rs.getInt("UserId");
                name = rs.getString("UserName");
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
                name = rs.getString("userName");
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
    public Collection<User> getAllUser() throws SQLException {
        Collection<User> userList = new ArrayList<>();
        try{
            int id = 0;
            String password = null;
            String name = null;

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM User";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("UserId");
                name = rs.getString("UserName");
                password = rs.getString("Password");
                userList.add(new User(id, name, password));
            }
            rs.close();
            ps.close();
        }
        finally {
            connection.close();
            return userList;
        }
    }

    @Override
    public void addUser(User user) {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO User (UserId, UserName, Password) VALUES(?, ?, ?)";
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
    public boolean deleteUser(User user) throws SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "DELETE FROM User WHERE UserId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId());
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
    public boolean deleteUser(int id) throws SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "DELETE FROM User WHERE UserId = ?";
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
}

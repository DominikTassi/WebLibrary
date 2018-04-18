import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoSubjectException;
import org.web.core.model.Subject;
import org.web.service.dao.SubjectDAO;

import java.sql.*;
import java.util.Collection;

public class SubjectDAOsql extends DataBaseInit implements SubjectDAO {

    private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    public SubjectDAOsql() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }

    @Override
    public Subject getSubject(int id) throws NoSubjectException {
        Subject subject = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int subjectId = 0;
            String name = null;


            String sql = "SELECT * FROM User WHERE SubjectId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                subjectId = rs.getInt("SubjectId");
                name = rs.getString("Name");
            }
            subject = new Subject(subjectId, name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NoNameException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return subject;
    }

    @Override
    public Subject getSubject(Subject subject) throws NoSubjectException {
        Subject localSubject = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int subjectId = 0;
            String name = null;


            String sql = "SELECT * FROM User WHERE SubjectId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,subject.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                subjectId = rs.getInt("SubjectId");
                name = rs.getString("Name");
            }
            subject = new Subject(subjectId, name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NoNameException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return localSubject;
    }

    @Override
    public Collection<Subject> getAllSubject() {
        Collection<Subject> allSubject = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            int subjectId = 0;
            String name = null;

            String sql = "SELECT * FROM Subject";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                subjectId = rs.getInt("SubjectId");
                name = rs.getString("SubjectName");
                allSubject.add(new Subject(subjectId, name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NoNameException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allSubject;
    }

    @Override
    public void addSubject(String subjectName) {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Subject (SubjectName) VALUES(?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subjectName);
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
}

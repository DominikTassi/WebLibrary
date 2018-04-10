import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInit {
    protected static String url = "jdbc:sqlite:./database/" + "WebLibraryDB";
    private static DataBaseInit instance = null;

    public DataBaseInit(){
        createDataBase();
    }

    public static DataBaseInit getInstance() {
        if (instance == null) {
            synchronized (DataBaseInit.class) {
                if (instance == null) {
                    instance = new DataBaseInit();
                }
            }
        }
        return instance;
    }

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(url);
        connection.setAutoCommit(false);
        return connection;
    }

    private static void createDataBase(){
        File file = new File("./database/WebLibraryDB");
        if (file.exists() && !file.isDirectory()) {
            System.out.println("Database already created");
            return;
        }
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
        Creating the database
         */

        try(Connection connection = DriverManager.getConnection(url)) {
            connection.setAutoCommit(false);
            if(connection != null){
                Statement statement = connection.createStatement();
                String sql = "CREATE TABLE Book\n" +
                        "(\n" +
                        "    ISBN INT PRIMARY KEY,\n" +
                        "    Name VARCHAR(255) NOT NULL,\n" +
                        "    SubjectId INT NOT NULL,\n" +
                        "    AuthorId INT NOT NULL,\n" +
                        "    Price INT NOT NULL,\n" +
                        "    PublisherId INT NOT NULL,\n" +
                        "    Date DATE NOT NULL,\n" +
                        "    Language INT NOT NULL\n" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Author(" +
                        "   AuthorId INT PRIMARY KEY NOT NULL," +
                        "   Name VARCHAR(255) NOT NULL," +
                        "   Birth DATE NOT NULL," +
                        "   Nationality VARCHAR(255) NOT NULL" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Borrow(" +
                        "   BookId INT PRIMARY KEY NOT NULL," +
                        "   UserId INT NOT NULL," +
                        "   Date DATE NOT NULL" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Publisher(" +
                        "   PublisherId INT PRIMARY KEY NOT NULL," +
                        "   Name VARCHAR(255) NOT NULL" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Stock(" +
                        "   BookId INT PRIMARY KEY NOT NULL," +
                        "   Piece INT NOT NULL" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Subject(" +
                        "   Id INT PRIMARY KEY NOT NULL," +
                        "   Subject VARCHAR(255) NOT NULL" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE User(" +
                        "   UserId INT PRIMARY KEY NOT NULL," +
                        "   Name VARCHAR(255) NOT NULL," +
                        "   Password VARCHAR (255) NOT NULL" +
                        ");";
                statement.execute(sql);
                System.out.println("Database created");
                connection.commit();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getConnectionString(){
        return url;
    }
}

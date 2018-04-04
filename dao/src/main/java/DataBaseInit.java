import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInit {
    protected static String url = "jdbc:sqlite:./database/" + "WebLibraryDB";

    public DataBaseInit(){
        init();
    }

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(url);
        connection.setAutoCommit(false);
        return connection;
    }

    public void init(){
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

        try(Connection connection = DriverManager.getConnection(url)) {
            if(connection != null){
                String sql1 = "CREATE TABLE Book\n" +
                        "(\n" +
                        "    ISBN INT PRIMARY KEY,\n" +
                        "    Name VARCHAR(255) NOT NULL,\n" +
                        "    Subject INT NOT NULL,\n" +
                        "    Author INT NOT NULL,\n" +
                        "    Price INT NOT NULL,\n" +
                        "    Publisher INT NOT NULL,\n" +
                        "    Date DATE NOT NULL,\n" +
                        "    Language INT NOT NULL\n" +
                        ");";

                String sql2 = "CREATE TABLE Author(" +
                        "   Id INT PRIMARY KEY NOT NULL," +
                        "   Name VARCHAR(255) NOT NULL," +
                        "   Birth DATE NOT NULL," +
                        "   Nationality INT NOT NULL" +
                        ");";

                Statement statement = connection.createStatement();
                statement.execute(sql1);
                statement.execute(sql2);
                System.out.println("Database created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String getConnectionString(){
        return url;
    }
}

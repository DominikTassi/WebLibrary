import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPasswordException;
import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws NoPasswordException, NoNameException, SQLException, ClassNotFoundException, NoUserException {
        DataBaseInit dataBaseInit = new DataBaseInit();
        UserDAOSql userDAOSql = new UserDAOSql();

        System.out.println("test");
        User user = new User(1, "name1", "password");
        User user2 = new User(2, "name2", "password3");
        System.out.println(userDAOSql.getUser(1).toString());
    }
}

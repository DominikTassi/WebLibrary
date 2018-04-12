import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPasswordException;
import org.web.core.exceptions.NoUserException;
import org.web.core.exceptions.WrongISBNException;
import org.web.core.model.Book;
import org.web.core.model.User;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws NoPasswordException, NoNameException, SQLException, ClassNotFoundException, NoUserException, WrongISBNException {
        DataBaseInit dataBaseInit = new DataBaseInit();
        //UserDAOSql userDAOSql = new UserDAOSql();
        BookDAOsql bookDAOsql = new BookDAOsql();

        System.out.println("test");


        Book book = bookDAOsql.getBookByISBN(1);
        System.out.println(book.toString());
        System.out.println(book.getPublisher().getName());
    }
}

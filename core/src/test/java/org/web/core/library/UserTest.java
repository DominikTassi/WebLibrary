package org.web.core.library;

import org.web.core.exceptions.NoNameException;
import org.web.core.exceptions.NoPasswordException;
import org.web.core.model.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class UserTest {
    private User testUser = null;

    @Before
    public void setUp() throws Exception{
        testUser = new User(1, "test", "password");
    }

    @Test
    public void getId() throws Exception{
        assertEquals(testUser.getId(), 1);
    }

    @Test
    public void getName() throws Exception{
        assertEquals(testUser.getName(), "test");
    }

    @Test
    public void getPassword() throws Exception{
        assertEquals(testUser.getPassword(), "password");
    }

    @Test
    public void setName() throws Exception{
        testUser.setName("newName");
        assertEquals(testUser.getName(),"newName");
    }

    @Test
    public void setPassword() throws Exception{
        testUser.setPassword("newPassword");
        assertEquals(testUser.getPassword(), "newPassword");
    }

    @Test
    public void equals() throws Exception{
        User sameUser = new User(1, "test", "password");
        assertTrue(testUser.equals(sameUser));
    }

    @Test
    public void notEquals() throws Exception{
        User notSameUser = new User(22, "notthesameuser", "notthesamepassword");
        assertFalse(testUser.equals(notSameUser));
    }

    @Test
    public void equalsWrongObj() throws Exception{
        Subject subject = new Subject(1, "family");
        assertFalse(testUser.equals(subject));
    }

    @Test
    public void equalsNull() throws Exception{
        assertFalse(testUser.equals(null));
    }

    @Test
    public void equalsSameObj() throws Exception{
        assertTrue(testUser.equals(testUser));
    }


    @Test(expected = NoNameException.class)
    public void noUserException() throws Exception{
        User wrongName = new User(1, "", "password");
    }

    @Test(expected = NoPasswordException.class)
    public void noPasswordException() throws Exception{
        User wrongPassword = new User(1, "wrongUser", "");
    }

}

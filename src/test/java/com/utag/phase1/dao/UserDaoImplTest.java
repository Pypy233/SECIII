package com.utag.phase1.dao;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.utag.phase1.dao.DaoService.UserDao;
import org.junit.Test;
import java.io.IOException;


import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    private static final String str = "admin";
    private static final String str1 = "py";
    private static final String str2 = "pypy233";


    @Test
    public void saveUser() throws IOException{
        assertEquals(false, userDao.saveUser(str1, str));
        assertEquals(false, userDao.saveUser(str, str));
        assertEquals(false, userDao.saveUser(str2, str2));

    }

    @Test
    public void deleteUser()  throws IOException{
        assertEquals(true, userDao.deleteUser(str2, str2));
    }

    @Test
    public void updateUser() throws IOException{
        assertEquals(true, userDao.updateUser(str, "update"));

    }

    @Test
    public void canLogin() throws IOException{
        assertEquals(true, userDao.canLogin(str, str));
        assertEquals(false, userDao.canLogin(str, str1));
    }

}
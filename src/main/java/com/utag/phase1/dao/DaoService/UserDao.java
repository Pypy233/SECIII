package com.utag.phase1.dao.DaoService;

import com.utag.phase1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * UserDaoImpl provide the data service interface (CURD)
 */
public interface UserDao {
    /**
     *
     * @return
     */
    public boolean saveUser(String user, String password) throws IOException;
    /**
     *
     * @return
     */
    public boolean deleteUser(String user, String password) throws IOException;

    /**
     *
     * @return
     */
    public boolean updateUser(String user, String password) throws IOException;


    /**
     *
     * @return
     */
    public boolean canLogin(String user, String password) throws IOException;

}

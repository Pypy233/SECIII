package com.utag.phase1.service.Impl;

import com.utag.phase1.dao.DaoService.UserDao;
import com.utag.phase1.dao.UserDaoImpl;
import com.utag.phase1.service.UserService;
import com.utag.phase1.util.Response;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;



public class UserServiceImpl implements UserService  {
    UserDao userDao = new UserDaoImpl();


    @Override
    public Response<Boolean> saveUser(String user, String password) throws IOException{
        Response<Boolean> response = new Response<>();
        if(userDao.saveUser(user, password)){
            response.setSuccess(true);
        }
        else{
            response.setSuccess(false);
        }
        return response;
    }

    @Override
    public Response<Boolean> deleteUser(String user, String password) throws IOException {
        Response<Boolean> response = new Response<>();
        if(userDao.deleteUser(user, password))
            response.setSuccess(true);
        else
            response.setSuccess(false);
        return response;
    }

    @Override
    public Response<Boolean> updateUser(String user, String password) throws IOException{
        Response<Boolean> response = new Response<>();
        if(userDao.updateUser(user, password))
            response.setSuccess(true);
        else
            response.setSuccess(false);
        return response;
    }

    @Override
    public Response<Boolean> canLogin(String user, String password) throws IOException{
        Response<Boolean> response = new Response<>();
        if(userDao.canLogin(user, password))
            response.setSuccess(true);
        else
            response.setSuccess(false);
        return response;
    }
}

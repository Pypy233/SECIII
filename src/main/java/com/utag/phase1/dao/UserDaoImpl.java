package com.utag.phase1.dao;

import com.google.gson.Gson;
import com.utag.phase1.dao.DaoService.UserDao;
import com.utag.phase1.domain.User;
import com.utag.phase1.util.FileTool;
import com.utag.phase1.util.GsonTool;
import java.io.IOException;
import java.util.ArrayList;


public class UserDaoImpl  implements UserDao {
    private static final String FILE_NAME = "user.json";


    private ArrayList<User> init() throws IOException{
        ArrayList<String> userStrList = (ArrayList<String>) FileTool.readFile(FILE_NAME);
        ArrayList<User> userList = new ArrayList<>();

        for(String str: userStrList){
            userList.add(GsonTool.getBean(str, User.class));
        }

        return userList;
    }

    @Override
    public boolean saveUser(String user, String password) throws IOException{
        User user1 = new User(user, password);
        String jsonStr = GsonTool.toJson(user1);
        return !(isUserExist(user)) && FileTool.writeFile(FILE_NAME, jsonStr);
    }

    @Override
    public boolean deleteUser(String user, String password) throws IOException{
        if(!isUserExist(user))
            return false;
        ArrayList<User> userList = init();
        ArrayList<String> contentList = new ArrayList<>();

        for(User u: userList){
            if(!u.getUsername().equals(user)) {
                User user1 = new User(u.getUsername(), u.getPassword());
                String jsonStr = GsonTool.toJson(user1);
                contentList.add(jsonStr);
            }
        }

        return FileTool.rewriteFile(FILE_NAME, contentList);
    }

    @Override
    public boolean updateUser(String user, String password) throws IOException{
        if(!isUserExist(user))
            return false;
        ArrayList<User> userList = init();
        ArrayList<String> contentList = new ArrayList<>();

        for(User u: userList){
            if(!u.getUsername().equals(user)) {
                contentList.add(GsonTool.toJson(new User(u.getUsername(), u.getPassword())));
            }
            else{
                contentList.add(GsonTool.toJson(new User(u.getUsername(), password)));
            }
        }

        return FileTool.rewriteFile(FILE_NAME, contentList);
    }

    @Override
    public boolean canLogin(String user, String password) throws IOException{
        if(!isUserExist(user))
            return false;

        ArrayList<String> userStrList = (ArrayList<String>) FileTool.readFile(FILE_NAME);

        for(String userStr: userStrList){
            User user1 = GsonTool.getBean(userStr, User.class);
            if(user1.getUsername().equals(user) && user1.getPassword().equals(password))
                return true;
        }
        return false;
    }

    private boolean isUserExist(String user) throws IOException{
        ArrayList<User> userList = init();
        for(User u: userList){
            if(u.getUsername().equals(user))
                return true;
        }
        return false;
    }

}

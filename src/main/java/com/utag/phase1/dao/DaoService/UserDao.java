package com.utag.phase1.dao.DaoService;


import java.io.IOException;

/**
 * 用户的数据层
 */
public interface UserDao {
    /**
     *增加用户
     * @return
     */
    public boolean saveUser(String user, String password) throws IOException;

    /**
     *删除用户
     * @return
     */
    public boolean deleteUser(String user, String password) throws IOException;

    /**
     *更新用户信息
     * @return
     */
    public boolean updateUser(String user, String password) throws IOException;


    /**
     *判断能否登录
     * @return
     */
    public boolean canLogin(String user, String password) throws IOException;

}

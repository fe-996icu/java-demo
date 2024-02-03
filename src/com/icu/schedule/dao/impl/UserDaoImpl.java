package com.icu.schedule.dao.impl;

import com.icu.schedule.dao.BaseDao;
import com.icu.schedule.dao.UserDao;
import com.icu.schedule.pojo.SysUser;

import java.util.List;


public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public SysUser getUserById(int uid) {
        String sql = "select uid, username, user_pwd userPwd from sys_user where uid=?";
        List<SysUser> list = this.baseQuery(SysUser.class, sql, uid);

        if(list.size() == 0)
            return null;

        return list.get(0);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        String sql = "select uid, username, user_pwd userPwd from sys_user where username=?";
        List<SysUser> list = this.baseQuery(SysUser.class, sql, username);

        if(list.size() == 0)
            return null;

        return list.get(0);
    }

    @Override
    public SysUser getUserByLogin(String username, String userPwd) {
        String sql = "select uid, username, user_pwd userPwd from sys_user where username=? and user_pwd=?";
        List<SysUser> list = this.baseQuery(SysUser.class, sql, username, userPwd);

        if(list.size() == 0)
            return null;

        return list.get(0);
    }
}

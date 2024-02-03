package com.icu.schedule.dao;

import com.icu.schedule.pojo.SysUser;

public interface UserDao {
    SysUser getUserById(int uid);
    SysUser getUserByUsername(String username);
    SysUser getUserByLogin(String username, String userPwd);
}

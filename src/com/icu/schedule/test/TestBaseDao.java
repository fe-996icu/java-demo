package com.icu.schedule.test;

import com.icu.schedule.dao.BaseDao;
import com.icu.schedule.dao.UserDao;
import com.icu.schedule.dao.impl.UserDaoImpl;
import com.icu.schedule.pojo.SysUser;
import com.icu.schedule.util.JDBCUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

//import
public class TestBaseDao {
    static BaseDao baseDao;

    // @BeforeClass在类初始化是前调用
    @BeforeClass
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }

    @Test
    public void testCount(){
        String sql = "select count(*) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println("--------------------------总用户数------------------------------");
        System.out.println(count);
    }

    @Test
    public void testUser(){
        String sql = "select uid,username,user_pwd userPwd from sys_user where username='zhangsan'";
        List<SysUser> users = baseDao.baseQuery(SysUser.class, sql);
        System.out.println("--------------------------单用户------------------------------");
        SysUser user = users.get(0);
        System.out.println(user);
    }

    @Test
    public void testUsers(){
        String sql = "select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> users = baseDao.baseQuery(SysUser.class, sql);
        System.out.println("--------------------------多用户------------------------------");
        System.out.println(users);
    }

    @Test
    public void testUserByUsername(){
        UserDao dao = new UserDaoImpl();
        SysUser user = dao.getUserByUsername("lisi5");

        System.out.println("--------------------------单用户-用户名------------------------------");
        System.out.println(user);

    }
}

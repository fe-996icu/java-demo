package com.icu.schedule.test;

import com.icu.schedule.pojo.SysSchedule;
import com.icu.schedule.pojo.SysUser;

public class TestLombok {
    public static void main(String args[]){
        SysUser user = new SysUser();
        SysUser user2 = new SysUser(1,"bbb", "ccc");

        String str = "aaa";

        int age = 111;

        System.out.println(age);

        System.out.println(user);

        System.out.println(str);

        SysSchedule schedule = new SysSchedule(1, 1, "name", 0);

        System.out.println(schedule);

    }
}

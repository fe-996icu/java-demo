package com.icu.schedule.test;

import com.icu.schedule.dao.ScheduleDao;
import com.icu.schedule.dao.impl.ScheduleDaoImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestScheduleDao {
    private static ScheduleDao dao;

    @BeforeClass
    public static void initDao() {
        dao = new ScheduleDaoImpl();
    }

    @Test
    public void testGetSchedulesByUid(){
        List list = dao.findSchedulesByUid(1);
        System.out.println("-----------------根据uid获取计划列表----------------------");
        System.out.println(list);
    }
}

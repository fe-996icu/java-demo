package com.icu.schedule.test;

import com.icu.schedule.common.ResultCodeEnum;
import com.icu.schedule.dao.ScheduleDao;
import com.icu.schedule.dao.impl.ScheduleDaoImpl;
import com.icu.schedule.utils.WebUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TestWebUtil {

    @Test
    public void testRead(){
        // WebUtil.readJson()
        System.out.println("-----------------根据uid获取计划列表----------------------");
        // System.out.println(list);

        ResultCodeEnum[] s = ResultCodeEnum.values();
        System.out.println(s);
    }
}

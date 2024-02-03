package com.icu.schedule.dao.impl;

import com.icu.schedule.dao.BaseDao;
import com.icu.schedule.dao.ScheduleDao;
import com.icu.schedule.pojo.SysSchedule;
import com.icu.schedule.pojo.SysUser;

import java.util.List;

public class ScheduleDaoImpl extends BaseDao implements ScheduleDao {
    @Override
    public SysSchedule getScheduleById(int sid) {
        String sql = "select sid, uid, title, completed from sys_schedule where sid=?";
        List<SysSchedule> list = baseQuery(SysSchedule.class, sql, sid);

        if(list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public List<SysSchedule> findSchedulesByTitle(String title) {
        String sql = "select sid, uid, title, completed from sys_schedule where title like %?%";
        List<SysSchedule> list = baseQuery(SysSchedule.class, sql, title);

        return list;
    }

    @Override
    public List<SysSchedule> findSchedulesByCompleteStatus(int uid, int isCompleted) {
        String sql = "select sid, uid, title, completed from sys_schedule where uid=? and completed=?";
        List<SysSchedule> list = baseQuery(SysSchedule.class, sql, uid, isCompleted);

        return list;
    }

    @Override
    public List<SysSchedule> findSchedulesByUid(int uid) {
        String sql = "select sid, uid, title, completed from sys_schedule where uid=?";
        List<SysSchedule> list = baseQuery(SysSchedule.class, sql, uid);

        return list;
    }

    @Override
    public boolean addSchedule(int uid, String title, int completed) {
        String sql = "insert uid, title, completed into sys_schedule values(?,?,?)";
        int count = this.baseUpdate(sql, uid, title, completed);
        return count == 1;
    }

    @Override
    public boolean removeScheduleById(int sid) {
        String sql = "delete from sys_schedule where sid=?";
        int count = this.baseUpdate(sql, sid);
        return count == 1;
    }

    @Override
    public boolean updateScheduleCompleteStatus(int sid, int isCompleted) {
        String sql = "update sys_schedule set completed=? where sid=?";
        int count = this.baseUpdate(sql, isCompleted, sid);
        return count == 1;
    }
}

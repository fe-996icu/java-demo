package com.icu.schedule.dao;

import com.icu.schedule.pojo.SysSchedule;

import java.util.List;

public interface ScheduleDao {
    SysSchedule getScheduleById(int sid);
    List<SysSchedule> findSchedulesByTitle(String title);
    List<SysSchedule> findSchedulesByCompleteStatus(int uid, int isCompleted);
    List<SysSchedule> findSchedulesByUid(int uid);
    boolean addSchedule(int uid, String title, int completed);
    boolean removeScheduleById(int sid);
    boolean updateScheduleCompleteStatus(int sid, int completed);
}

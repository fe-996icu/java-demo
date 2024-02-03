package com.icu.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysSchedule implements Serializable {
//    继续完善实体类
    private int sid;
    private int uid;
    private String title;
    private int completed;
}

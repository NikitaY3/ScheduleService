package com.y3school.schedule.service;

import com.y3school.schedule.entity.TodayTable;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/

public interface TodayService {
    TodayTable findByDayId(String dayId);

    List<TodayTable> findByDayIdLike(String dayId);

    TodayTable updateTodayTable(TodayTable todayTable);

    TodayTable insertTodayTable(TodayTable todayTable);

    void deleteByDayId(String dayId);

    void deleteByDayIdLike(String dayId);
}

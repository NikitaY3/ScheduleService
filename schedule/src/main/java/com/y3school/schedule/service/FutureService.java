package com.y3school.schedule.service;

import com.y3school.schedule.entity.FutureTable;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface FutureService {

    FutureTable findByDayId(String dayId);

    List<FutureTable> findByDayIdLike(String dayId);

    FutureTable updateFutureTable(FutureTable futureTable);

    FutureTable insertFutureTable(FutureTable futureTable);

    void deleteByDayId(String dayId);

    void deleteByDayIdLike(String dayId);
}

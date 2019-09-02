package com.y3school.schedule.service;

import com.y3school.schedule.entity.FinishTable;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface FinishService {
    FinishTable findByFinishId(String finishId);

    List<FinishTable> findByDayIdLike(String dayId);

    FinishTable insertFinishInfo(FinishTable finishTable);

    FinishTable updateFinishInfo(FinishTable finishTable);

    void deleteByFinishId(String finishId);

    void deleteByDayIdLike(String dayId);
}

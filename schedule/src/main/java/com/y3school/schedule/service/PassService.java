package com.y3school.schedule.service;

import com.y3school.schedule.entity.PassTable;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface PassService {
    PassTable findByDayId(String dayId);

    List<PassTable> findByDayIdLike(String dayId);

    PassTable insertPassInfo(PassTable passTable);

    PassTable updatePassInfo(PassTable passTable);

    void deleteByDayId(String dayId);

    void deleteByDayIdLike(String dayId);

}

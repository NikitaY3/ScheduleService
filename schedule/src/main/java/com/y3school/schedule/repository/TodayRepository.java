package com.y3school.schedule.repository;

import com.y3school.schedule.entity.TodayTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface TodayRepository extends JpaRepository<TodayTable, String> {
    TodayTable findByDayId(String dayId);

    List<TodayTable> findByDayIdLike(String dayId);

    void deleteByDayId(String dayId);

    void deleteByDayIdLike(String dayId);
}

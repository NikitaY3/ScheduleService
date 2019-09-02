package com.y3school.schedule.repository;

import com.y3school.schedule.entity.FutureTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface FutureRepository extends JpaRepository<FutureTable, String> {
    FutureTable findByDayId(String dayId);

    List<FutureTable> findByDayIdLike(String dayId);

    void deleteByDayId(String dayId);

    void deleteByDayIdLike(String dayId);
}

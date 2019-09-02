package com.y3school.schedule.repository;

import com.y3school.schedule.entity.FinishTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface FinishRepository extends JpaRepository<FinishTable, String> {
    FinishTable findByFinishId(String finishId);

    List<FinishTable> findByDayIdLike(String dayId);

    void deleteByDayIdLike(String dayId);
}

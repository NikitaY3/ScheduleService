package com.y3school.schedule.repository;

import com.y3school.schedule.entity.PassTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface PassRepository extends JpaRepository<PassTable, String> {
    PassTable findByDayId(String dayId);

    List<PassTable> findByDayIdLike(String dayId);

    void deleteByDayId(String dayId);

    void deleteByDayIdLike(String dayId);
}

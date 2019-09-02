package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.TodayTable;
import com.y3school.schedule.service.TodayService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TodayServiceImplTest {

//    @Autowired
    private TodayService todayService;

    @Test
    public void findByDayId() {
        TodayTable todayTable = todayService.findByDayId("18711660142");
        Assert.assertNotNull(todayTable);
    }

    @Test
    public void updateTodayTable() {
        TodayTable todayTable = new TodayTable();
        todayTable.setCheckbox(false);
        todayTable.setDayId("18711660142");
        todayTable.setDiary("这是日程注解");
        todayTable.setRemind(true);
        todayTable.setTitle("第一个日程");
        TodayTable result = todayService.updateTodayTable(todayTable);

        Assert.assertNotNull(result);
    }

    @Test
    public void insertTodayTable() {
        TodayTable todayTable = new TodayTable();
        todayTable.setCheckbox(true);
        todayTable.setDayId("18711660142");
        todayTable.setDiary("sdjasjdhakjsdhkdhkjad");
        todayTable.setRemind(true);
        todayTable.setTitle("dasdada");
        TodayTable result = todayService.insertTodayTable(todayTable);

        Assert.assertNotNull(result);
    }

    @Test
    public void deleteByDayId() {

        todayService.deleteByDayId("17673202422");
    }

    @Test
    public void date2Byte() {
        Date date = new Date();
        System.out.println(String.valueOf(date));
    }
}
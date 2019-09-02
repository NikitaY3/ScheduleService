package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.PassTable;
import com.y3school.schedule.service.PassService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PassServiceImplTest {

    @Autowired
    private PassService passService;

    @Test
    public void findByDayId() {
        PassTable passTable = passService.findByDayId("18711660142");
        Assert.assertNotNull(passTable);
    }

    @Test
    public void findByDayIdLike() {

        List<PassTable> result = passService.findByDayIdLike("1");
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void insertPassInfo() {
        PassTable passTable = new PassTable();
        passTable.setDayId("18711660142");
        passTable.setPassDay(new Date(new java.util.Date().getTime()));
        PassTable result = passService.insertPassInfo(passTable);
        assertNotNull(result.getDayId());
    }

    @Test
    public void updatePassInfo() {
        PassTable passTable = new PassTable();
        passTable.setDayId("18711660142");
        passTable.setPassDay(new Date(new java.util.Date().getTime()));
        passTable.setCompletion(10);
        PassTable result = passService.updatePassInfo(passTable);
        assertNotNull(result.getDayId());
    }

    @Test
    public void deleteByDayId() {
        passService.deleteByDayId("18711660142");
    }
}
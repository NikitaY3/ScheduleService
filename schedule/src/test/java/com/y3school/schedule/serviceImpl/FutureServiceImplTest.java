package com.y3school.schedule.serviceImpl;

import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.entity.FutureTable;
import com.y3school.schedule.service.FutureService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FutureServiceImplTest {

    @Autowired
    private FutureService futureService;

    @Test
    public void findByDayId() {
        FutureTable result = futureService.findByDayId("18711660142");

        Assert.assertNotNull(result);
    }

    @Test
    public void updateFutureTable() {
        FutureTable futureTable = new FutureTable();
        futureTable.setDayId("18711660142");
        futureTable.setDiary("妹纸");
        futureTable.setTitle("大妹纸");
        futureTable.setEndDay(new Date(new java.util.Date().getTime()));

        FutureTable result = futureService.updateFutureTable(futureTable);
        Assert.assertNotNull(result);

    }

    @Test
    public void insertFutureTable() {
        FutureTable futureTable = new FutureTable();
        futureTable.setDayId("18711660142");
        futureTable.setRepeatType("aksdhajkdhk");
        futureTable.setDiary("暮忆雨眠");
        futureTable.setTitle("小妹纸");
        futureTable.setEndDay(new Date(new java.util.Date().getTime()));

        FutureTable result = futureService.insertFutureTable(futureTable);
        Assert.assertNotNull(result);
    }

    @Test
    public void deleteByDayId() {
        futureService.deleteByDayId("18711660142");
    }

}
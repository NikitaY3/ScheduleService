package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.FinishTable;
import com.y3school.schedule.service.FinishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FinishServiceImplTest {

    @Autowired
    private FinishService finishService;

    @Test
    public void findByFinishId() {
        FinishTable result = finishService.findByFinishId("18711660142");
        assertNotNull(result);
    }

    @Test
    public void insertFinishInfo() {
        FinishTable finishTable = new FinishTable();
        finishTable.setCheckbox(false);
        finishTable.setFinishId("18711660142");
        finishTable.setDayId("18711660142");
        finishTable.setRemind(false);
        finishTable.setTitle("妹纸");
        finishTable.setTime(new SimpleDateFormat("yyyyMMdd").format(new Date()));

        FinishTable result = finishService.insertFinishInfo(finishTable);
        assertNotNull(result);
    }

    @Test
    public void updateFinishInfo() {
        FinishTable finishTable = new FinishTable();

        finishTable.setFinishId("18711660142");
        finishTable.setTitle("妹纸");
        finishTable.setTime(new SimpleDateFormat("yyyyMMdd").format(new Date()));

        FinishTable result = finishService.updateFinishInfo(finishTable);
        assertNotNull(result);

    }

    @Test
    public void deleteByFinishId() {
        finishService.deleteByFinishId("18711660142");
    }
}
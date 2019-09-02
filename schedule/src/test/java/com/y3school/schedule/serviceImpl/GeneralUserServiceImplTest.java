package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.GeneralUserTable;
import com.y3school.schedule.service.GeneralUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

/**
 * @Author
 * @Description 用户信息服务单元测试类
 * @Date 2019/8/16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneralUserServiceImplTest {

    @Autowired
    private GeneralUserService generalUserService;

    @Test
    public void findUserInfoByNameid() {
        GeneralUserTable result = generalUserService.findUserInfoByNameid("12345678901");
        Assert.assertNotNull(result);
    }

    @Test
    public void insertUserInfo() {
        GeneralUserTable generalUser = new GeneralUserTable();
        generalUser.setNameId("18711660142");
        generalUser.setName("汤圆");
        generalUser.setPassword("123456");
        //时间戳
        generalUser.setBirthday(new java.sql.Date(new Date().getTime()));
        GeneralUserTable result = generalUserService.insertUserInfo(generalUser);

        Assert.assertNotNull(result);
    }

    @Test
    public void deleteUserInfoByNameid() {
        generalUserService.deleteUserInfoByNameid("12345678901");
    }

    @Test
    public void updateUserInfo() {
        GeneralUserTable generalUser = new GeneralUserTable();
        generalUser.setNameId("18711660142");
        generalUser.setName("妹纸");
        generalUser.setPassword("123456");
        //时间戳
        generalUser.setBirthday(new java.sql.Date(new Date().getTime()));

        GeneralUserTable result = generalUserService.updateUserInfo(generalUser);
        Assert.assertNotNull(result);
    }
}
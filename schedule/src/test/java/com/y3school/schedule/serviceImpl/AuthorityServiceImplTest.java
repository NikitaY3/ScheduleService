package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.AuthorityTable;
import com.y3school.schedule.service.AuthorityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityServiceImplTest {

    @Autowired
    private AuthorityService authorityService;

    @Test
    public void findBySnameIdAndGnameId() {
        AuthorityTable authorityTable = authorityService.findBySnameIdAndGnameId("18711660142",
                "17673202422");
        Assert.assertNotNull(authorityTable);
    }

    @Test
    public void findBySnameId() {
        List<AuthorityTable> resultList = authorityService.findBySnameId("18711660142");
        Assert.assertNotEquals(0, resultList.size());
    }

    @Test
    public void findByGnameId() {
        List<AuthorityTable> resultList = authorityService.findByGnameId("17673202422");
        Assert.assertNotEquals(0, resultList.size());
    }

    @Test
    public void insertAuthority() {
        AuthorityTable authorityTable = new AuthorityTable();
        authorityTable.setSnameId("17673202422");
        authorityTable.setGnameId("18711660142");
        AuthorityTable result = authorityService.insertAuthority(authorityTable);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateAuthority() {
        System.out.println(UUID.randomUUID());
    }

    @Test
    public void deleteBySnameIdAndGnameId() {
        authorityService.deleteBySnameIdAndGnameId("18711660142", "17673202422");
    }
}
package com.y3school.schedule.repository;

import com.y3school.schedule.entity.GeneralUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * @Description 用户信息实体JPA操作接口定义类
 * @Date 2019/8/16
 **/
@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUserTable, String> {
    /**
     * 根据用户信息表主键查询
     * @param nameId 待查询主键值
     * @return 查询结果
     */
    GeneralUserTable findByNameId(String nameId);
}

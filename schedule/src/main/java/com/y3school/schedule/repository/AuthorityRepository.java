package com.y3school.schedule.repository;

import com.y3school.schedule.entity.AuthorityTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface AuthorityRepository extends JpaRepository<AuthorityTable, Integer> {
    AuthorityTable findBySnameIdAndGnameId(String snameId, String gnameId);

    /**
     * 特权用户查询拥有哪些用户的插入权限
     * @param snameId
     * @return
     */
    List<AuthorityTable> findBySnameId(String snameId);

    /**
     * 普通用户查询给哪些用户权限过
     * @param gnameId
     * @return
     */
    List<AuthorityTable> findByGnameId(String gnameId);

    void deleteBySnameIdAndGnameId(String snameId, String gnameId);
}

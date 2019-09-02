package com.y3school.schedule.service;

import com.y3school.schedule.entity.AuthorityTable;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
public interface AuthorityService {

    /**
     * 根据参数查询一条记录
     * @param snameId 特权用户编号
     * @param gnameId 普通用户编号
     * @return 返回一条记录
     */
    AuthorityTable findBySnameIdAndGnameId(String snameId, String gnameId);

    List<AuthorityTable> findBySnameId(String snameId);

    List<AuthorityTable> findByGnameId(String gnameId);

    AuthorityTable insertAuthority(AuthorityTable authorityTable);

    AuthorityTable updateAuthority(AuthorityTable authorityTable);

    void deleteBySnameIdAndGnameId(String snameId, String gnameId);
}

package com.y3school.schedule.service;

import com.y3school.schedule.entity.GeneralUserTable;

/**
 * 用户表服务接口定义
 * @Author
 * @Description
 * @Date 2019/8/16
 **/
public interface GeneralUserService {
    GeneralUserTable findUserInfoByNameid(String nameId);

    /**
     * 插入一条新数据
     * @param generalUser 待插入数据实体
     * @return 返回插入后的数据
     */
    GeneralUserTable insertUserInfo(GeneralUserTable generalUser);

    /**
     * 根据主键删除数据
     * @param nameId 待删除数据主键
     */
    void deleteUserInfoByNameid(String nameId);

    /**
     * 更新一条数据
     * @param generalUser 待更新信息
     * @return 更新后的信息
     */
    GeneralUserTable updateUserInfo(GeneralUserTable generalUser);
}

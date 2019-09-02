package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.GeneralUserTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.repository.GeneralUserRepository;
import com.y3school.schedule.service.GeneralUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author TomShiDi
 * @Description 事务
 * @Date 2019/8/16
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class GeneralUserServiceImpl implements GeneralUserService {

    private GeneralUserRepository repository;


    @Autowired
    public GeneralUserServiceImpl(GeneralUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public GeneralUserTable findUserInfoByNameid(String nameId) {
        return repository.findByNameId(nameId);
    }

    @Override
    public GeneralUserTable insertUserInfo(GeneralUserTable generalUser) {
        GeneralUserTable generalUserTable = repository.findByNameId(generalUser.getNameId());
        if (generalUserTable != null) {
            throw new ScheduleException(ScheduleEnum.GENERAL_USER_INFO_REPEAT);
        }
        return repository.save(generalUser);
    }

    @Override
    public void deleteUserInfoByNameid(String nameId) {
        repository.deleteById(nameId);
    }

    @Override
    public GeneralUserTable updateUserInfo(GeneralUserTable generalUser) {
        GeneralUserTable result = repository.findByNameId(generalUser.getNameId());
        if (result == null) {
            throw new ScheduleException(ScheduleEnum.CANNOT_FIND_USER_INFO);
        }
        BeanUtils.copyProperties(generalUser, result, "createTime");
        return repository.save(result);
    }

}

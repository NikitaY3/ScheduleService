package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.PassTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.repository.PassRepository;
import com.y3school.schedule.service.PassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author TomShiDi
 * @Description
 * @Date 2019/8/17
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class PassServiceImpl implements PassService {

    private PassRepository repository;

    @Autowired
    public PassServiceImpl(PassRepository repository) {
        this.repository = repository;
    }

    @Override
    public PassTable findByDayId(String dayId) {
        PassTable passTable = repository.findByDayId(dayId);
        if (passTable == null) {
            throw new ScheduleException(ScheduleEnum.PASS_INFO_NOT_FOUND);
        }
        return passTable;
    }

    @Override
    public List<PassTable> findByDayIdLike(String dayId) {
        return repository.findByDayIdLike("%" + dayId + "%");
    }

    @Override
    public PassTable insertPassInfo(PassTable passTable) {
        return repository.save(passTable);
    }

    @Override
    public PassTable updatePassInfo(PassTable passTable) {
        PassTable passTable1 = repository.findByDayId(passTable.getDayId());
        if (passTable1 == null) {
            throw new ScheduleException(ScheduleEnum.PASS_INFO_NOT_FOUND);
        }
        BeanUtils.copyProperties(passTable, passTable1, "createTime");
        PassTable result = repository.save(passTable1);
        if (result.getDayId() == null) {
            throw new ScheduleException(ScheduleEnum.PASS_INFO_SAVE_ERROR);
        }
        return result;
    }

    @Override
    public void deleteByDayId(String dayId) {
        repository.deleteByDayId(dayId);
    }


    @Override
    public void deleteByDayIdLike(String dayId) {
        repository.deleteByDayIdLike("%" + dayId + "%");
    }
}

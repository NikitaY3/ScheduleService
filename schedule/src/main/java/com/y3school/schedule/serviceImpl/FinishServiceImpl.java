package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.FinishTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.repository.FinishRepository;
import com.y3school.schedule.service.FinishService;
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
public class FinishServiceImpl implements FinishService {

    private FinishRepository repository;

    @Autowired
    public FinishServiceImpl(FinishRepository repository) {
        this.repository = repository;
    }

    @Override
    public FinishTable findByFinishId(String finishId) {
        FinishTable finishTable = repository.findByFinishId(finishId);
        if (finishTable == null) {
            throw new ScheduleException(ScheduleEnum.FINISH_INFO_NOT_FOUND);
        }
        return finishTable;
    }

    @Override
    public List<FinishTable> findByDayIdLike(String dayId) {
        return repository.findByDayIdLike("%" + dayId + "%");
    }

    @Override
    public FinishTable insertFinishInfo(FinishTable finishTable) {
        return repository.save(finishTable);
    }

    @Override
    public FinishTable updateFinishInfo(FinishTable finishTable) {
        FinishTable finishTable1 = repository.findByFinishId(finishTable.getFinishId());
        if (finishTable1 == null) {
            throw new ScheduleException(ScheduleEnum.FINISH_INFO_NOT_FOUND);
        }
        BeanUtils.copyProperties(finishTable, finishTable1, "createTime");
        return repository.save(finishTable1);
    }

    @Override
    public void deleteByFinishId(String finishId) {
        repository.deleteById(finishId);
    }

    @Override
    public void deleteByDayIdLike(String dayId) {
        repository.deleteByDayIdLike("%" + dayId + "%");
    }
}

package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.FutureTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.repository.FutureRepository;
import com.y3school.schedule.service.FutureService;
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
public class FutureServiceImpl implements FutureService {

    private FutureRepository repository;

    @Autowired
    public FutureServiceImpl(FutureRepository repository) {
        this.repository = repository;
    }

    @Override
    public FutureTable findByDayId(String dayId) {
        FutureTable futureTable = repository.findByDayId(dayId);
        if (futureTable == null) {
            throw new ScheduleException(ScheduleEnum.FUTURE_INFO_NOT_FOUND);
        }
        return futureTable;
    }

    @Override
    public List<FutureTable> findByDayIdLike(String dayId) {
        return repository.findByDayIdLike("%" + dayId + "%");
    }

    @Override
    public FutureTable updateFutureTable(FutureTable futureTable) {
        FutureTable futureTable1 = repository.findByDayId(futureTable.getDayId());
        FutureTable result = null;
        if (futureTable1 == null) {
            throw new ScheduleException(ScheduleEnum.FUTURE_INFO_NOT_FOUND);
        }

        BeanUtils.copyProperties(futureTable, futureTable1, "createTime");
        result = repository.save(futureTable1);
        return result;
    }

    @Override
    public FutureTable insertFutureTable(FutureTable futureTable) {
        FutureTable futureTable1 = repository.findByDayId(futureTable.getDayId());
        if (futureTable1 != null) {
            throw new ScheduleException(ScheduleEnum.FUTURE_INFO_REPEAT);
        }
        return repository.save(futureTable);
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

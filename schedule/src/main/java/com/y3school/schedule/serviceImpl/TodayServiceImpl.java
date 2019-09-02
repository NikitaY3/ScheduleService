package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.TodayTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.repository.TodayRepository;
import com.y3school.schedule.service.TodayService;
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
public class TodayServiceImpl implements TodayService {

    private TodayRepository repository;

    @Autowired
    public TodayServiceImpl(TodayRepository repository) {
        this.repository = repository;
    }

    @Override
    public TodayTable findByDayId(String dayId) {
        TodayTable todayTable = repository.findByDayId(dayId);
        if (todayTable == null) {
            throw new ScheduleException(ScheduleEnum.TODAY_INFO_NOT_FOUND);
        }
        return todayTable;
    }

    @Override
    public List<TodayTable> findByDayIdLike(String dayId) {
        return repository.findByDayIdLike("%" + dayId + "%");
    }

    @Override
    public TodayTable updateTodayTable(TodayTable todayTable) {
        TodayTable todayTable1 = repository.findByDayId(todayTable.getDayId());
        TodayTable result = null;

        if (todayTable1 != null) {
            BeanUtils.copyProperties(todayTable, todayTable1, "createTime");
            result = repository.save(todayTable1);
        }else {
            throw new ScheduleException(ScheduleEnum.TODAY_INFO_NOT_FOUND);
        }
        return result;
    }

    @Override
    public TodayTable insertTodayTable(TodayTable todayTable) {

        return repository.save(todayTable);
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

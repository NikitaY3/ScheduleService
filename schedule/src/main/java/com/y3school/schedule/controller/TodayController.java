package com.y3school.schedule.controller;

import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.entity.TodayTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.service.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/18
 **/
@RestController
@RequestMapping("/today")
public class TodayController {

    private TodayService todayService;

    @Autowired
    public TodayController(TodayService todayService) {
        this.todayService = todayService;
    }

    @GetMapping("/findbyid")
    public CommonDTO findByDayId(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        TodayTable result = todayService.findByDayId(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @GetMapping("/findall")
    public CommonDTO findByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        List<TodayTable> passTableList = todayService.findByDayIdLike(dayId);

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(passTableList);
        return commonDTO;
    }

    @PostMapping("/save")
    public CommonDTO saveFutureInfo(@Valid TodayTable todayTable,
                                    BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        TodayTable result = todayService.insertTodayTable(todayTable);
        if (result.getDayId() == null) {
            commonDTO.setCode(ScheduleEnum.TODAY_INFO_SAVE_ERROR.getCode());
            commonDTO.setMessage(ScheduleEnum.TODAY_INFO_SAVE_ERROR.getMessage());
            return commonDTO;
        }

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }


    @PostMapping("/update")
    public CommonDTO updateFutureInfo(@Valid TodayTable todayTable,
                                    BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        TodayTable result = todayService.updateTodayTable(todayTable);
        if (result.getDayId() == null) {
            commonDTO.setCode(ScheduleEnum.TODAY_INFO_SAVE_ERROR.getCode());
            commonDTO.setMessage(ScheduleEnum.TODAY_INFO_SAVE_ERROR.getMessage());
            return commonDTO;
        }

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @GetMapping("/deletebyid")
    public CommonDTO deleteByDayId(@RequestParam(name = "dayId") String dayId) {

        CommonDTO commonDTO = new CommonDTO();
        todayService.deleteByDayId(dayId);
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }

    @RequestMapping("/deletebyidlike")
    public CommonDTO deleteByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        todayService.deleteByDayIdLike(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }
}

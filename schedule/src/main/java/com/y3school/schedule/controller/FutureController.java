package com.y3school.schedule.controller;

import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.entity.FutureTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.service.FutureService;
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
@RequestMapping("/future")
public class FutureController {

    private FutureService futureService;

    @Autowired
    public FutureController(FutureService futureService) {
        this.futureService = futureService;
    }

    @GetMapping("/findbyid")
    public CommonDTO queryFutureInfo(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        FutureTable futureTable = futureService.findByDayId(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(futureTable);

        return commonDTO;
    }

    @GetMapping("/findall")
    public CommonDTO findByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        List<FutureTable> passTableList = futureService.findByDayIdLike(dayId);

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(passTableList);
        return commonDTO;
    }

    @PostMapping("/save")
    public CommonDTO insertFutureInfo(@Valid FutureTable futureTable,
                                      BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        FutureTable result = futureService.insertFutureTable(futureTable);

        if (result.getDayId() == null) {
            commonDTO.setMessage(ScheduleEnum.FUTURE_INFO_SAVE_ERROR.getMessage());
            commonDTO.setCode(ScheduleEnum.FUTURE_INFO_SAVE_ERROR.getCode());
            return commonDTO;
        }

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @PostMapping("/update")
    public CommonDTO updateFutureInfo(@Valid FutureTable futureTable,
                                      BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        FutureTable result = futureService.updateFutureTable(futureTable);

        if (result.getDayId() == null) {
            commonDTO.setMessage(ScheduleEnum.FUTURE_INFO_SAVE_ERROR.getMessage());
            commonDTO.setCode(ScheduleEnum.FUTURE_INFO_SAVE_ERROR.getCode());
            return commonDTO;
        }

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @RequestMapping("/deletebyid")
    public CommonDTO deleteByDayId(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        futureService.deleteByDayId(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }

    @RequestMapping("/deletebyidlike")
    public CommonDTO deleteByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        futureService.deleteByDayIdLike(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }
}

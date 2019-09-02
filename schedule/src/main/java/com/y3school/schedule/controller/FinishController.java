package com.y3school.schedule.controller;

import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.entity.FinishTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.service.FinishService;
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
@RequestMapping("/finish")
public class FinishController {

    private FinishService finishService;

    @Autowired
    public FinishController(FinishService finishService) {
        this.finishService = finishService;
    }

    @GetMapping("/findbyid")
    public CommonDTO findByFinishId(@RequestParam(name = "finishId") String finishId) {
        CommonDTO commonDTO = new CommonDTO();

        FinishTable result = finishService.findByFinishId(finishId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @GetMapping("/findall")
    public CommonDTO findByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        List<FinishTable> finishTableList = finishService.findByDayIdLike(dayId);

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(finishTableList);
        return commonDTO;
    }

    @PostMapping("/save")
    public CommonDTO saveFinishInfo(@Valid FinishTable finishTable,
                                    BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        FinishTable result = finishService.insertFinishInfo(finishTable);

        if (result.getFinishId() == null) {
            commonDTO.setCode(ScheduleEnum.FINISH_INFO_SAVE_ERROR.getCode());
            commonDTO.setMessage(ScheduleEnum.FINISH_INFO_SAVE_ERROR.getMessage());
            return commonDTO;
        }

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @PostMapping("/update")
    public CommonDTO updateFinishInfo(@Valid FinishTable finishTable,
                                    BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        FinishTable result = finishService.updateFinishInfo(finishTable);

        if (result.getFinishId() == null) {
            commonDTO.setCode(ScheduleEnum.FINISH_INFO_SAVE_ERROR.getCode());
            commonDTO.setMessage(ScheduleEnum.FINISH_INFO_SAVE_ERROR.getMessage());
            return commonDTO;
        }

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setData(result);
        return commonDTO;
    }

    @GetMapping("/deletebyid")
    public CommonDTO deleteFinishInfo(@RequestParam(name = "finishId") String finishId) {
        CommonDTO commonDTO = new CommonDTO();

        finishService.deleteByFinishId(finishId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }

    @RequestMapping("/deletebyidlike")
    public CommonDTO deleteByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        finishService.deleteByDayIdLike(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }
}

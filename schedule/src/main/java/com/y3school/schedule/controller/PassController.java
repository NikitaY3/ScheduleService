package com.y3school.schedule.controller;

import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.entity.PassTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.service.PassService;
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
@RequestMapping("/pass")
public class PassController {

    private PassService passService;

    @Autowired
    public PassController(PassService passService) {
        this.passService = passService;
    }

    @GetMapping("/findbyid")
    public CommonDTO findById(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        PassTable passTable = passService.findByDayId(dayId);

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(passTable);
        return commonDTO;
    }

    @GetMapping("/findall")
    public CommonDTO findByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        List<PassTable> passTableList = passService.findByDayIdLike(dayId);

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(passTableList);
        return commonDTO;
    }

    @PostMapping("/save")
    public CommonDTO savePassInfo(@Valid PassTable passTable,
                                  BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        PassTable result = passService.insertPassInfo(passTable);

        if (result.getDayId() == null) {
            commonDTO.setMessage(ScheduleEnum.PASS_INFO_SAVE_ERROR.getMessage());
            commonDTO.setCode(ScheduleEnum.PASS_INFO_SAVE_ERROR.getCode());
            return commonDTO;
        }

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(result);
        return commonDTO;
    }

    @PostMapping("/update")
    public CommonDTO updatePassInfo(@Valid PassTable passTable,
                                  BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();

        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        PassTable result = passService.updatePassInfo(passTable);

        if (result.getDayId() == null) {
            commonDTO.setMessage(ScheduleEnum.PASS_INFO_SAVE_ERROR.getMessage());
            commonDTO.setCode(ScheduleEnum.PASS_INFO_SAVE_ERROR.getCode());
            return commonDTO;
        }

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(result);
        return commonDTO;
    }


    @GetMapping("/deletebyid")
    public CommonDTO deleteByDayId(@RequestParam(name = "dayId") String dayId) {

        CommonDTO commonDTO = new CommonDTO();
        passService.deleteByDayId(dayId);
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }


    @RequestMapping("/deletebyidlike")
    public CommonDTO deleteByDayIdLike(@RequestParam(name = "dayId") String dayId) {
        CommonDTO commonDTO = new CommonDTO();

        passService.deleteByDayIdLike(dayId);

        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        return commonDTO;
    }
}

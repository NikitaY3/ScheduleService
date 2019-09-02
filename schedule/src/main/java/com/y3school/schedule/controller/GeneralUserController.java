package com.y3school.schedule.controller;

import com.y3school.schedule.dto.GeneralUserDTO;
import com.y3school.schedule.entity.GeneralUserTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.service.GeneralUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author
 * @Description
 * @Date 2019/8/16
 **/
@RestController
@RequestMapping("/user")
public class GeneralUserController {

    private GeneralUserService generalUserService;

    @Autowired
    public GeneralUserController(GeneralUserService generalUserService) {
        this.generalUserService = generalUserService;
    }

    @GetMapping("/findbyid")
    public GeneralUserDTO getUserInfoByNameid(@RequestParam("nameId") String nameId,
                                                @RequestParam(name = "password") String password) {
        GeneralUserDTO generalUserDTO = new GeneralUserDTO();
        if (nameId == null || nameId.isEmpty()) {
            throw new ScheduleException(ScheduleEnum.NAME_ID_IS_EMPTY);
        }

        GeneralUserTable result = generalUserService.findUserInfoByNameid(nameId);

        if (result == null) {
            generalUserDTO.setCode(ScheduleEnum.USER_PASSWORD_NOT_EQUAL.getCode());
            generalUserDTO.setMessage(ScheduleEnum.USER_PASSWORD_NOT_EQUAL.getMessage());
            return generalUserDTO;
        }

        //判断账号密码是否匹配
        if (!password.equals(result.getPassword())) {
            generalUserDTO.setCode(ScheduleEnum.USER_PASSWORD_NOT_EQUAL.getCode());
            generalUserDTO.setMessage(ScheduleEnum.USER_PASSWORD_NOT_EQUAL.getMessage());
            return generalUserDTO;
        }

        generalUserDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        generalUserDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        generalUserDTO.setData(result);
        return generalUserDTO;
    }


    @PostMapping("/save")
    public GeneralUserDTO addGeneralUserInfo(@Valid GeneralUserTable generalUserTable,
                                             BindingResult bindingResult) {

        GeneralUserDTO generalUserDTO = new GeneralUserDTO();
        if (bindingResult.hasErrors()) {
            generalUserDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return generalUserDTO;
        }

        GeneralUserTable result = generalUserService.insertUserInfo(generalUserTable);
        if (result.getNameId() == null) {
            generalUserDTO.setMessage(ScheduleEnum.GENERAL_USER_INFO_SAVE_ERROR.getMessage());
            generalUserDTO.setCode(ScheduleEnum.GENERAL_USER_INFO_SAVE_ERROR.getCode());
            return generalUserDTO;
        }

        generalUserDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        generalUserDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        generalUserDTO.setData(result);

        return generalUserDTO;
    }

    @PostMapping("/update")
    public GeneralUserDTO updateUserInfo(@Valid GeneralUserTable generalUserTable,
                                         BindingResult bindingResult) {
        GeneralUserDTO generalUserDTO = new GeneralUserDTO();
        if (bindingResult.hasErrors()) {
            generalUserDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return generalUserDTO;
        }

        GeneralUserTable result = generalUserService.updateUserInfo(generalUserTable);
        if (result.getNameId() == null) {
            generalUserDTO.setMessage(ScheduleEnum.GENERAL_USER_INFO_SAVE_ERROR.getMessage());
            generalUserDTO.setCode(ScheduleEnum.GENERAL_USER_INFO_SAVE_ERROR.getCode());
            return generalUserDTO;
        }

        generalUserDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        generalUserDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        generalUserDTO.setData(result);

        return generalUserDTO;
    }

    @GetMapping("/delete")
    public GeneralUserDTO deleteUserInfo(@RequestParam("nameId") String nameId) {

        GeneralUserDTO generalUserDTO = new GeneralUserDTO();

        if (nameId.trim().isEmpty()) {
            generalUserDTO.setMessage("登录账号为空");
            return generalUserDTO;
        }

        generalUserService.deleteUserInfoByNameid(nameId);
        generalUserDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        generalUserDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        return generalUserDTO;
    }
}

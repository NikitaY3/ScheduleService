package com.y3school.schedule.controller;

import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.entity.AuthorityTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    private AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @PostMapping("/save")
    public CommonDTO saveAuthorityInfo(@Valid AuthorityTable authorityTable,
                                       BindingResult bindingResult) {
        CommonDTO commonDTO = new CommonDTO();
        if (bindingResult.hasErrors()) {
            commonDTO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return commonDTO;
        }

        AuthorityTable result = authorityService.insertAuthority(authorityTable);
        if (result.getAuthorizationId() == null) {
            commonDTO.setMessage(ScheduleEnum.AUTHORITY_INFO_SAVE_ERROR.getMessage());
            commonDTO.setCode(ScheduleEnum.AUTHORITY_INFO_SAVE_ERROR.getCode());
            return commonDTO;
        }

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(result);

        return commonDTO;
    }

    @GetMapping("/query")
    public CommonDTO queryAuthorityInfo(@RequestParam(name = "snameId",required = false)String snameId,
                                        @RequestParam(name = "gnameId",required = false)String gnameId){
        CommonDTO commonDTO = new CommonDTO();
        List<AuthorityTable> authorityTableList = null;
        if ((snameId == null || snameId.isEmpty()) && (gnameId == null || gnameId.isEmpty())) {
            commonDTO.setMessage("请输入查询参数");
            return commonDTO;
        }

        if (gnameId != null && !gnameId.isEmpty()) {
            authorityTableList = authorityService.findByGnameId(gnameId);
        }else {
            authorityTableList = authorityService.findBySnameId(snameId);
        }

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());
        commonDTO.setData(authorityTableList);

        return commonDTO;
    }

    @GetMapping("/delete")
    public CommonDTO delete(@RequestParam(name = "snameId") String snameId,
                            @RequestParam(name = "gnameId") String gnameId) {
        CommonDTO commonDTO = new CommonDTO();
        authorityService.findBySnameIdAndGnameId(snameId, gnameId);
        authorityService.deleteBySnameIdAndGnameId(snameId, gnameId);

        commonDTO.setMessage(ScheduleEnum.SUCCESS_CODE.getMessage());
        commonDTO.setCode(ScheduleEnum.SUCCESS_CODE.getCode());

        return commonDTO;
    }
}

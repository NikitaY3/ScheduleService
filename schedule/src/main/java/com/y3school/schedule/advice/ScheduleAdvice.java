package com.y3school.schedule.advice;

import com.y3school.schedule.dto.CommonDTO;
import com.y3school.schedule.exceptions.ScheduleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author
 * @Description
 * @Date 2019/8/18
 **/
//如果加了这个注解，这个类会作为拦截器，拦截系统所有的异常，此时控制台没有报错，要看报错需要注释掉这个注解
//@ControllerAdvice
public class ScheduleAdvice {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonDTO handleException(Exception exception) {
        CommonDTO commonDTO = new CommonDTO();

        //判断拦截的异常是不是我们自己定义的异常，如果不是，就重新构造一个自定义的异常
        //如果是自定义的异常，就直接强转
        ScheduleException scheduleException = exception instanceof ScheduleException ?
                (ScheduleException) exception : new ScheduleException(exception.getMessage(), 500);
        commonDTO.setMessage(scheduleException.getMessage());
        commonDTO.setCode(scheduleException.getCode());

        return commonDTO;
    }
}

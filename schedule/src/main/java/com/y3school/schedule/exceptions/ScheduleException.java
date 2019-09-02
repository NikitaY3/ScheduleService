package com.y3school.schedule.exceptions;

import com.y3school.schedule.enums.ScheduleEnum;

/**
 * @Author
 * @Description
 * @Date 2019/8/16
 **/
public class ScheduleException extends RuntimeException {

    private String message;

    private Integer code;


    public ScheduleException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }


    /**
     * 枚举类型构造函数
     * @param scheduleEnum
     */
    public ScheduleException(ScheduleEnum scheduleEnum) {
        super(scheduleEnum.getMessage());
        this.code = scheduleEnum.getCode();
        this.message = scheduleEnum.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

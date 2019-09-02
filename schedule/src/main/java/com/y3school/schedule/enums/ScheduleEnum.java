package com.y3school.schedule.enums;

/**
 * @Author
 * @Description
 * @Date 2019/8/16
 **/
public enum ScheduleEnum {
    /**
     * 找不到用户信息
     */
    CANNOT_FIND_USER_INFO("找不到用户信息", 1000),
    NAME_ID_IS_EMPTY("用户编号为空", 1001),
    CANNOT_FIND_AUTHORITY_INFO("找不到授权信息", 1002),
    AUTHORITY_INFO_SAVE_ERROR("授权信息保存失败", 1003),
    AUTHORITY_INFO_REPEAT("授权信息已存在", 1004),
    TODAY_INFO_NOT_FOUND("找不到日程信息", 1005),
    FUTURE_INFO_NOT_FOUND("找不到未来日程", 1006),
    FINISH_INFO_NOT_FOUND("未找到已完成日程信息", 1007),
    PASS_INFO_NOT_FOUND("未找到过期日程信息", 1008),
    PASS_INFO_SAVE_ERROR("过期日程信息保存失败", 1009),
    GENERAL_USER_INFO_SAVE_ERROR("用户信息保存失败", 1010),
    GENERAL_USER_INFO_REPEAT("账号已存在", 1011),
    FUTURE_INFO_REPEAT("未来日程重复", 1012),
    USER_PASSWORD_NOT_EQUAL("账号密码不匹配", 1013),
    FUTURE_INFO_SAVE_ERROR("未来日程保存不成功", 1014),
    TODAY_INFO_SAVE_ERROR("今日日程保存不成功", 1015),
    FINISH_INFO_SAVE_ERROR("finish日程保存不成功", 1016),

    SUCCESS_CODE("操作成功", 111),
    ;



    private String message;

    private Integer code;


    ScheduleEnum(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

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

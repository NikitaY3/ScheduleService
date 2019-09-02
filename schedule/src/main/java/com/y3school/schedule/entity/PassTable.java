package com.y3school.schedule.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@Entity(name = "pass")
public class PassTable {

    @Id
    private String dayId;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date passDay;

    private Integer completion;

    private Date createTime;

    private Date updateTime;

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPassDay() {
        return passDay;
    }

    public void setPassDay(Date passDay) {
        this.passDay = passDay;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

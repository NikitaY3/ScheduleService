package com.y3school.schedule.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 用户信息表映射实体
 * @Author
 * @Description
 * @Date 2019/8/16
 **/
@Entity(name = "general_user")
public class GeneralUserTable {
    @Id
    private String nameId;

    private String name = "记日程";

    @NotEmpty(message = "请输入密码")
    private String password;

    private String sex = "男";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String head;

    private Date createTime;

    private Date updateTime;

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
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

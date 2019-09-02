package com.y3school.schedule.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

/**
 * @Author
 * @Description
 * @Date 2019/8/17
 **/
@Entity(name = "authority")
public class AuthorityTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorizationId;

    @NotEmpty(message = "用户账号为空")
    private String gnameId;

    @NotEmpty(message = "用户账号为空")
    private String snameId;

    private Date createTime;

    private Date updateTime;

    public Integer getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(Integer authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getGnameId() {
        return gnameId;
    }

    public void setGnameId(String gnameId) {
        this.gnameId = gnameId;
    }

    public String getSnameId() {
        return snameId;
    }

    public void setSnameId(String snameId) {
        this.snameId = snameId;
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

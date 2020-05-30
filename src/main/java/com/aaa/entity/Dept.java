package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Dept {
    private Integer deptId;    //部门id

    private String deptName;//部门名称

    private Integer orderNum;//显示顺序

    private String status;//部门状态（0正常 1停用

    private String delFlag; //删除标志（0代表存在 2代表删除）

    private String createBy;//创建者
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    private String updateBy; //更新者

    private Date updateTime;//更新时间

}
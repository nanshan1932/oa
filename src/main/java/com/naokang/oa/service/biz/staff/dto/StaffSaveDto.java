package com.naokang.oa.service.biz.staff.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StaffSaveDto {
    /**
     * 姓名
     */
    @NotBlank
    private String name;


    /**
     * 1男 2女
     */
    @NotNull
    private Integer sex;


    /**
     * 身份证号码
     */
    @NotBlank
    private String idNumber;


    /**
     * 学历 1中专 2大专 3本科 4研究生...
     */
    private Integer education;


    /**
     * 民族
     */
    private String ethnicity;


    /**
     * 婚姻状况 1未婚 2已婚 3离异 4丧偶
     */
    private Integer maritalStatus;


    /**
     * 部门
     */
    private Integer deptId;


    /**
     * 岗位
     */
    private Integer post;


    /**
     * 职称
     */
    private String title;


    /**
     * 毕业院校
     */
    private String graduateInstitution;


    /**
     * 专业
     */
    private String major;


    /**
     * 生日
     */
    private Integer birthDay;


    /**
     * 户口所在地
     */
    private String registeredPermanentResidence;


    /**
     * 现住址
     */
    private String address;


    /**
     * 入职日期
     */
    private Date entryDate;


    /**
     * 离职日期
     */
    private Date resignationDate;


    /**
     * 联系方式
     */
    private String telNumber;


    /**
     * 紧急联系人
     */
    private String contactPerson;

    /**
     * 电话
     */
    private String contractPeriodTel;

    /**
     * 合同期限
     */
    private String contractPeriod;
}

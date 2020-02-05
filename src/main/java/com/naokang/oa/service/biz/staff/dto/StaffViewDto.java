package com.naokang.oa.service.biz.staff.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author wangsai
 * @date 2020/1/18
 */
@Data
public class StaffViewDto {
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;


    /**
     * 1男 2女
     */
    private String sexTxt;


    /**
     * 身份证号码
     */
    private String idNumber;


    /**
     * 学历 1中专 2大专 3本科 4研究生...
     */
    private String educationTxt;


    /**
     * 民族
     */
    private String ethnicity;


    /**
     * 婚姻状况 1未婚 2已婚 3离异 4丧偶
     */
    private Integer maritalStatusTxt;


    /**
     * 部门
     */
    private String department;


    /**
     * 岗位
     */
    private String postTxt;


    /**
     * 职称
     */
    private String titleTxt;


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
     * 合同期限
     */
    private String contractPeriod;


    /**
     * 社保id
     */
    private Integer ssId;

}

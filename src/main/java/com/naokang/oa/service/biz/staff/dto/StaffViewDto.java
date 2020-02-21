package com.naokang.oa.service.biz.staff.dto;

import com.naokang.oa.common.dto.BaseViewDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author wangsai
 * @date 2020/1/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StaffViewDto extends BaseViewDto {
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
    private Integer sex;


    /**
     * 身份证号码
     */
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
     * 紧急联系人电话
     */
    private String contactPersonTel;

    /**
     * 合同期限
     */
    private String contractPeriod;

    /**
     * 是否缴纳社保
     */
    private Integer ssFlag;


    /**
     * 性别
     */
    private String sexTxt;

    /**
     * 学历
     */
    private String educationTxt;

    /**
     * 岗位
     */
    private String postTxt;

    /**
     * 婚姻状况
     */
    private String maritalStatusTxt;

    /**
     * 部门
     */
    private String department;

    /**
     * 是否缴纳社保
     */
    private String ssFlagTxt;

}

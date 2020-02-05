package com.naokang.oa.dao.biz.staff.entity;

import com.naokang.oa.dao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *  员工表
 *
 * @author 
 * @since 2020-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StaffEntity extends BaseEntity {

    private static final long serialVersionUID = 6880763198370524458L;

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
    private Integer title;


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

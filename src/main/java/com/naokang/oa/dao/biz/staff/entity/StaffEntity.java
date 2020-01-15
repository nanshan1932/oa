package com.naokang.oa.dao.biz.staff.entity;

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
@Accessors(chain = true)
public class StaffEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Integer ethnicity;


    /**
     * 婚姻状况 1未婚 2已婚 3离异 4丧偶
     */
    private Integer maritalStatus;


    /**
     * 部门
     */
    private Integer department;


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
     * 社保卡号
     */
    private String socialSecurityNum;


    /**
     * 社保办理月份
     */
    private Integer socialSecurityPayMonth;


    /**
     * 断保月份
     */
    private Integer socialSecurityStopMonth;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 操作人Id
     */
    private Integer optId;

    /**
     * 标识(是否有效 0有效；-1无效)
     */
    private Integer mark;

    /**
     * 初始化添加时间与修改时间
     */
    public void initAddUpdateTime() {
        setAddTime(new Date());
        setUpdateTime(new Date());
    }
}

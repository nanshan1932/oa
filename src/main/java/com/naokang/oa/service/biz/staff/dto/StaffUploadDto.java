package com.naokang.oa.service.biz.staff.dto;

import com.naokang.oa.common.dto.BaseViewDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.handler.inter.IExcelModel;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class StaffUploadDto  extends BaseViewDto implements IExcelModel {

    /**
     * 失败原因
     */
    private String errorMsg;

    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0")
    private String name;


    /**
     * 1男 2女
     */
    private Integer sex;

    /**
     * 性别
     */
    @Excel(name = "性别", orderNum = "1")
    private String sexTxt;


    /**
     * 身份证号码
     */
    @Excel(name = "身份证号码", orderNum = "2")
    private String idNumber;


    /**
     * 学历 1中专 2大专 3本科 4研究生...
     */
    private Integer education;

    /**
     * 学历
     */
    @Excel(name = "学历", orderNum = "3")
    private String educationTxt;


    /**
     * 民族
     */
    @Excel(name = "民族", orderNum = "4")
    private String ethnicity;


    /**
     * 婚姻状况 1未婚 2已婚 3离异 4丧偶
     */
    private Integer maritalStatus;

    /**
     * 婚姻状况
     */
    @Excel(name = "婚姻状况", orderNum = "5")
    private String maritalStatusTxt;

    /**
     * 部门
     */
    private Integer deptId;

    /**
     * 部门
     */
    @Excel(name = "部门", orderNum = "6")
    private String department;

    /**
     * 岗位
     */
    private Integer post;

    /**
     * 岗位
     */
    @Excel(name = "岗位", orderNum = "7")
    private String postTxt;



    /**
     * 职称
     */
    @Excel(name = "职称", orderNum = "8")
    private String title;


    /**
     * 毕业院校
     */
    @Excel(name = "毕业院校", orderNum = "9")
    private String graduateInstitution;


    /**
     * 专业
     */
    @Excel(name = "专业", orderNum = "10")
    private String major;


    /**
     * 生日
     */
    @Excel(name = "生日", orderNum = "11")
    private Integer birthDay;


    /**
     * 户口所在地
     */
    @Excel(name = "户口所在地", orderNum = "12")
    private String registeredPermanentResidence;


    /**
     * 现住址
     */
    @Excel(name = "现住址", orderNum = "13")
    private String address;


    /**
     * 入职日期
     */
    @Excel(name = "入职日期", orderNum = "14")
    private Date entryDate;


    /**
     * 离职日期
     */
    @Excel(name = "离职日期", orderNum = "15")
    private Date resignationDate;


    /**
     * 联系方式
     */
    @Excel(name = "联系方式", orderNum = "16")
    private String telNumber;


    /**
     * 紧急联系人
     */
    @Excel(name = "紧急联系人", orderNum = "17")
    private String contactPerson;

    /**
     * 紧急联系人电话
     */
    @Excel(name = "紧急联系人电话", orderNum = "18")
    private String contactPersonTel;

    /**
     * 合同期限
     */
    @Excel(name = "合同期限", orderNum = "19")
    private String contractPeriod;

    /**
     * 是否缴纳社保
     */
    private Integer ssFlag;

    /**
     * 是否缴纳社保
     */
    @Excel(name = "是否缴纳社保", orderNum = "20")
    private String ssFlagTxt;

}

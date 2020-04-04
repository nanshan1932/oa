package com.naokang.oa.dao.biz.socialsecurity.entity;

import com.naokang.oa.dao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SocialSecurityDetailEntity extends BaseEntity {

    private static final long serialVersionUID = -2540415298761054057L;
    /**
     * 员工id
     */
    private Integer staffId;

    /**
     * 社保卡号
     */
    private String ssNo;

    /**
     * 社保办理月份
     */
    private Integer payMonth;

    /**
     * 断保月份
     */
    private Integer stopMonth;

    /**
     * 姓名
     */
    private String name;


    /**
     * 1男 2女
     */
    private Integer sex;

    /**
     * 性别
     */
    private String sexTxt;


    /**
     * 身份证号码
     */
    private String idNumber;

    /**
     * 部门
     */
    private Integer deptId;

    /**
     * 部门
     */
    private String department;

    /**
     * 在职状态  0 在职  -1 离职
     */
    private Integer jobFlag;

    /**
     * 在职状态
     */
    private String jobFlagTxt;

    /**
     * 社保
     */
    private Integer ssFlag;

    /**
     * 是否缴纳社保
     */
    private String ssFlagTxt;
}

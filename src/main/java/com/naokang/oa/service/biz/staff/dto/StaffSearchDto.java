package com.naokang.oa.service.biz.staff.dto;

import com.naokang.oa.common.dto.BaseParamDto;
import lombok.Data;

import java.util.Date;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@Data
public class StaffSearchDto extends BaseParamDto {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 部门
     */
    private Integer deptId;

    /**
     * 生日 月份
     */
    private Integer birthDay;

    /**
     * 入职日期   从
     */
    private Date entryDateStart;

    /**
     * 入职日期  至
     */
    private Date entryDateEnd;

    /**
     * 是否缴纳社保 social security（ss）
     */
    private Integer ssFlag;

    /**
     * 职称
     */
    private String title;

}

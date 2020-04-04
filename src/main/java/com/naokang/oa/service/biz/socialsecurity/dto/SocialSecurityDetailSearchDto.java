package com.naokang.oa.service.biz.socialsecurity.dto;

import com.naokang.oa.common.dto.BaseParamDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SocialSecurityDetailSearchDto extends BaseParamDto {
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
     * 是否缴纳社保 social security（ss）
     */
    private Integer ssFlag;

    /**
     * 是否在职
     */
    private Integer jobFlag;

}

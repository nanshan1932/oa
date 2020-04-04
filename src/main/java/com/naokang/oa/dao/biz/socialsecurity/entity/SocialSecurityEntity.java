package com.naokang.oa.dao.biz.socialsecurity.entity;

import com.naokang.oa.dao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 社保
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SocialSecurityEntity extends BaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2992131295825753829L;

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
}

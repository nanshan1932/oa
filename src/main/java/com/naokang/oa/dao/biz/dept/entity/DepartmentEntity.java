package com.naokang.oa.dao.biz.dept.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DepartmentEntity {

    /**
     * id
     */
    private Integer id;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 名称
     */
    private String deptName;

    /**
     * 状态
     */
    private Integer status;

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
}

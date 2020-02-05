package com.naokang.oa.dao.biz.dept.entity;

import com.naokang.oa.dao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DepartmentEntity extends BaseEntity {

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

}

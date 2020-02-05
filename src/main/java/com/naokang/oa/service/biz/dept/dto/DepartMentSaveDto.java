package com.naokang.oa.service.biz.dept.dto;

import lombok.Data;

@Data
public class DepartMentSaveDto {

    /**
     * 父级ID
     */
    private Integer parentId;

    /**
     * 部门名称
     */
    private String deptName;
}

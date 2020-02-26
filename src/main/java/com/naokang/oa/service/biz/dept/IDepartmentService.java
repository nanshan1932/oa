package com.naokang.oa.service.biz.dept;

import com.naokang.oa.dao.biz.dept.entity.DepartmentEntity;
import com.naokang.oa.service.base.IBaseService;
import com.naokang.oa.service.biz.dept.dto.DepartMentSaveDto;

import java.util.Map;

public interface IDepartmentService extends IBaseService<DepartmentEntity> {

    /**
     * 获取本门树形数据
     * @return
     */
    Map<String, Object> getTreeDeptList();

    /**
     * 添加部门
     * @param dto
     */
    void addDept(DepartMentSaveDto dto);

    /**
     * 通过部门Id获取部门名称
     * @param deptId
     * @return
     */
    String getDeptNameById(Integer deptId);

    /**
     * 通过部门名称获取部门ID
     * @param deptName
     * @return
     */
    Integer getDeptIdByName(String deptName);
}

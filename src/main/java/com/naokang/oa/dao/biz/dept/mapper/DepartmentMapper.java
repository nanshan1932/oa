package com.naokang.oa.dao.biz.dept.mapper;

import com.naokang.oa.dao.base.mapper.IBaseMapper;
import com.naokang.oa.dao.biz.dept.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentMapper extends IBaseMapper<DepartmentEntity> {

    /**
     * 查询部门树状图节点
     * @param entityInfo
     * @return
     */
    List<DepartmentEntity> selectTreeDeptList(DepartmentEntity entityInfo);
}

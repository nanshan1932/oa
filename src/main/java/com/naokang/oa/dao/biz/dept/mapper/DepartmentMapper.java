package com.naokang.oa.dao.biz.dept.mapper;

import com.naokang.oa.dao.base.mapper.BaseMapper;
import com.naokang.oa.dao.biz.dept.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<DepartmentEntity> {

    /**
     * 查询部门树状图节点
     * @param entityInfo
     * @return
     */
    List<DepartmentEntity> selectTreeDeptList(DepartmentEntity entityInfo);
}

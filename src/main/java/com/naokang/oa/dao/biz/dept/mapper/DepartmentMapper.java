package com.naokang.oa.dao.biz.dept.mapper;

import com.naokang.oa.dao.biz.dept.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    /**
     * 新增
     * @param entity
     */
    void insertInto(DepartmentEntity entity);

    /**
     * 删除数据
     * @param id
     * @return
     */
    Integer deleteById(@Param("id") Integer id);

    /**
     * 查询
     * @param entity
     * @return
     */
    DepartmentEntity selectEntity(DepartmentEntity entity);

    /**
     * 查询
     * @param entity
     * @return
     */
    List<DepartmentEntity> selectEntities(DepartmentEntity entity);

    /**
     * 查询部门树状图节点
     * @param entityInfo
     * @return
     */
    List<DepartmentEntity> selectTreeDeptList(DepartmentEntity entityInfo);
}

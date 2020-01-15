package com.naokang.oa.dao.biz.staff.mapper;


import com.naokang.oa.dao.biz.staff.entity.StaffEntity;

import java.util.List;
import java.util.Map;

/**
 *  员工表 Mapper 接口
 *
 * @author 
 * @since 2020-01-15
 */
public interface StaffMapper {

    /**
     * 新增
     * @param entity
     */
    void insertInto(StaffEntity entity);


    /**
     * 更新
     * @param entity
     * @return
     */
    Integer updateInto(StaffEntity entity);

    /**
     * 查询
     * @param entity
     * @return
     */
    StaffEntity selectEntity(StaffEntity entity);

    /**
     * 查询
     * @param entity
     * @return
     */
    List<StaffEntity> selectEntities(StaffEntity entity);

    /**
     * 查询分页数量
     * @param paramMap
     * @return
     */
    Integer selectPageCount(Map<String, Object> paramMap);

    /**
     * 分页查询
     * @param paramMap
     * @return
     */
    List<StaffEntity> selectPageEntities(Map<String, Object> paramMap);
}


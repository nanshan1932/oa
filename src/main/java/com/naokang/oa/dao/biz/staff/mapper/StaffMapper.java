package com.naokang.oa.dao.biz.staff.mapper;


import com.naokang.oa.dao.base.mapper.IBaseMapper;
import com.naokang.oa.dao.biz.staff.entity.StaffEntity;

import java.util.List;

/**
 *  员工表 Mapper 接口
 *
 * @author 
 * @since 2020-01-15
 */
public interface StaffMapper extends IBaseMapper<StaffEntity> {
    /**
     * 批量插入
     * @param staffEntities
     */
    void insertBatch(List<StaffEntity> staffEntities);
}


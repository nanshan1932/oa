package com.naokang.oa.service.base;

import com.naokang.oa.dao.base.entity.BaseEntity;
import com.naokang.oa.dao.base.mapper.IBaseMapper;

import java.util.List;
import java.util.Map;

public interface IBaseService<T extends BaseEntity> {

    /**
     * 获取mapper
     *
     * @return
     */
    IBaseMapper<T> getMapper();

    /**
     * 新增
     * @param entityInfo
     */
    void insertInto(T entityInfo);

    /**
     * 更新
     * @param entityInfo
     * @return
     */
    int updateInto(T entityInfo);

    /**
     * 删除数据
     * @param entityInfo
     * @return
     */
    void invalidEntity(T entityInfo);

    /**
     * 查询
     * @param entityInfo
     * @return
     */
    T selectEntity(T entityInfo);

    /**
     * 查询
     * @param entityInfo
     * @return
     */
    List<T> selectEntities(T entityInfo);

    /**
     * 获取List<T>分页对象
     *
     * @param paramMap
     * @return List<T>
     */
    List<T> selectPageEntities(Map<String, Object> paramMap);

    /**
     * 执行分页查询T对象
     *
     * @param paramMap 查询参数
     * @return Map<String, Object>
     */
    Map<String, Object> doPageSelect(Map<String, Object> paramMap);
}

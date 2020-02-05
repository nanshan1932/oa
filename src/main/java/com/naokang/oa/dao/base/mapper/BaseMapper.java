package com.naokang.oa.dao.base.mapper;

import com.naokang.oa.dao.base.entity.BaseEntity;
import com.naokang.oa.dao.biz.dept.entity.DepartmentEntity;
import com.naokang.oa.dao.biz.dictionary.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T extends BaseEntity> {
    /**
     * 新增
     * @param entity
     */
    void insertInto(T entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    Integer updateInto(T entity);

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
    T selectEntity(T entity);

    /**
     * 查询
     * @param entity
     * @return
     */
    List<T> selectEntities(T entity);

    /**
     * 获取记录Count数量
     *
     * @param paramMap
     * @return Integer
     */
    Integer selectPageCount(Map<String, Object> paramMap);

    /**
     * 获取List<T>分页对象
     *
     * @param paramMap
     * @return List<T>
     */
    List<T> selectPageEntities(Map<String, Object> paramMap);
}

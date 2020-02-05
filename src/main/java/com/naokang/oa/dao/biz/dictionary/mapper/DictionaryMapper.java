package com.naokang.oa.dao.biz.dictionary.mapper;

import com.naokang.oa.dao.biz.dictionary.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典
 */
public interface DictionaryMapper {
    /**
     * 新增
     * @param entity
     */
    void insertInto(DictionaryEntity entity);


    /**
     * 更新
     * @param entity
     * @return
     */
    Integer updateInto(DictionaryEntity entity);

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
    DictionaryEntity selectEntity(DictionaryEntity entity);

    /**
     * 查询
     * @param entity
     * @return
     */
    List<DictionaryEntity> selectEntities(DictionaryEntity entity);


    List<DictionaryEntity> selectPageEntities(Map<String, Object> param);

    Integer selectPageCount(Map<String, Object> param);
}

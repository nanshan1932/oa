package com.naokang.oa.service.base.impl;

import com.naokang.oa.common.constants.SysConstants;
import com.naokang.oa.common.exception.BusinessException;
import com.naokang.oa.dao.base.entity.BaseEntity;
import com.naokang.oa.service.base.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public abstract class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public T selectEntity(T entityInfo) {
        entityInfo.setMark(SysConstants.MarkType.VALID);
        return getMapper().selectEntity(entityInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertInto(T entityInfo){
        entityInfo.setOptId(9999);
        entityInfo.setMark(SysConstants.MarkType.VALID);
        entityInfo.initAddUpdateTime();
        getMapper().insertInto(entityInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateInto(T entityInfo) {
        entityInfo.setOptId(9999);
        entityInfo.setUpdateTime(new Date());
        return getMapper().updateInto(entityInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void invalidEntity(T entityInfo) {
        T entity = createActualEntity();
        entity.setId(entityInfo.getId());
        entity.setMark(SysConstants.MarkType.INVALID);
        updateInto(entity);
    }

    @SuppressWarnings("unchecked")
    private T createActualEntity() {
        Type type = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            return (T) Class.forName(type.getTypeName()).newInstance();
        } catch (ReflectiveOperationException ex) {
            throw new BusinessException("BaseServiceImpl.createActualEntity failed. type:" + type.getTypeName(), ex);
        }
    }


    /**
     * 查询
     * @param entityInfo
     * @return
     */
    @Override
    public List<T> selectEntities(T entityInfo) {
        entityInfo.setMark(SysConstants.MarkType.VALID);
        return getMapper().selectEntities(entityInfo);
    }

    /**
     * 分页获取List<T>对象
     *
     * @param paramMap
     * @return List<T>
     */
    @Override
    public List<T> selectPageEntities(Map<String, Object> paramMap) {
        paramMap.put("mark", SysConstants.MarkType.VALID);
        return getMapper().selectPageEntities(paramMap);
    }

    /**
     * 执行分页查询
     *
     * @param paramMap
     * @return
     */
    @Override
    public Map<String, Object> doPageSelect(Map<String, Object> paramMap) {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<T> list = null;
        Integer total = 0;
        try {
            total = getMapper().selectPageCount(paramMap);
            if (total > 0) {
                list = getMapper().selectPageEntities(paramMap);
            }
        } catch (Exception e) {
            log.warn("分页查询失败", e);
        }
        resultMap.put("total", total);
        resultMap.put("rows", list != null ? list : new ArrayList<T>());
        return resultMap;
    }

}

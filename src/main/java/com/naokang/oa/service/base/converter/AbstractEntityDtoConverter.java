package com.naokang.oa.service.base.converter;

import com.naokang.oa.common.dto.BaseParamDto;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractEntityDtoConverter<E, D> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 实体列表直接转map列表，仅供导出数据功能使用。
     * @param entityList
     * @param dtoClass
     * @return
     */
    public final List<Map<String, Object>> convertEntityList2MapList(List<E> entityList,
                                                                     Class<D> dtoClass) {
        return convertViewDtoList2MapList(convert2ViewDtoList(entityList, dtoClass));
    }

    /**
     * 模板方法，实体列表转视图dto列表。<br>
     * 默认只转换名称与类型相同的字段。
     *
     * @param entityList 待转换实体列表
     * @param dtoClass dto类型
     * @return dto列表
     */
    public final List<D> convert2ViewDtoList(List<E> entityList, Class<D> dtoClass) {
        List<D> dtoList = new ArrayList<>();
        if (CollectionUtils.isEmpty(entityList)) {
            return dtoList;
        }

        try {
            E source = entityList.get(0);
            BeanCopier beanCopier = BeanCopier.create(source.getClass(), dtoClass, false);
            for (E entity : entityList) {
                D dto = dtoClass.newInstance();
                beanCopier.copy(entity, dto, null);
                convert2ViewDtoPostHandle(entity, dto);
                dtoList.add(dto);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("实体列表转视图dto列表出错！", e);
        }
        return dtoList;
    }

    /**
     * 模板方法，实体转视图dto。<br>
     * 默认只转换名称与类型相同的字段。
     *
     * @param entity 待转换实体对象
     * @param dtoClass dto类型
     * @return
     */
    public final D convert2ViewDto(E entity, Class<D> dtoClass) {
        Assert.notNull(entity, "数据不存在！");
        try {
            BeanCopier beanCopier = BeanCopier.create(entity.getClass(), dtoClass, false);
            D dto = dtoClass.newInstance();
            beanCopier.copy(entity, dto, null);
            convert2ViewDtoPostHandle(entity, dto);
            return dto;
        }
        catch (Exception e) {
            throw new RuntimeException("实体转视图dto出错！", e);
        }
    }

    public final D convert2ViewDto(E entity) {
        Class<D> clz = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return convert2ViewDto(entity, clz);
    }

    /**
     * 实体转视图dto后处理方法，需要子类实现
     * @param entity 实体对象
     * @param dto dto对象
     */
    protected abstract void convert2ViewDtoPostHandle(E entity, D dto);

    /**
     * 视图dto列表转为map列表。<br>
     * 仅供导出数据使用。
     * @param dtoList 视图dto列表
     * @return
     */
    public final List<Map<String, Object>> convertViewDtoList2MapList(List<D> dtoList) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(dtoList)) {
            return list;
        }

        try {
            for (D dto : dtoList) {
                list.add(convertViewDto2Map(dto));
            }
        }
        catch (Exception e) {
            throw new RuntimeException("视图dto列表转map列表出错！", e);
        }
        return list;
    }

    /**
     * 视图dto转换为map，需要子类实现。<br>
     * 仅供导出数据使用。
     * @param dto 视图dto对象
     * @return
     */
    protected abstract Map<String, Object> convertViewDto2Map(D dto);

    /**
     * 模板方法，参数dto转实体。<br>
     * 默认只转换名称与类型相同的字段。
     *
     * @param paramDto 参数dto对象
     * @param entityClass 实体类型
     * @return 实体对象
     */
    public final E convertParamDto2Entity(BaseParamDto paramDto, Class<E> entityClass) {
        Assert.notNull(paramDto, "参数dto为null！");
        try {
            BeanCopier beanCopier = BeanCopier.create(paramDto.getClass(), entityClass, false);
            E entity = entityClass.newInstance();
            beanCopier.copy(paramDto, entity, null);
            convertParamDto2EntityPostHandle(paramDto, entity);
            return entity;
        }
        catch (Exception e) {
            throw new RuntimeException("参数dto转实体出错！", e);
        }
    }

    /**
     * 参数dto转实体后处理方法，需要子类实现
     * @param paramDto 参数dto对象
     * @param entity 实体对象
     */
    protected abstract void convertParamDto2EntityPostHandle(BaseParamDto paramDto, E entity);
}

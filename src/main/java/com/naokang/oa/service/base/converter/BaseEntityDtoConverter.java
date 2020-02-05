package com.naokang.oa.service.base.converter;

import com.naokang.oa.common.dto.BaseParamDto;
import com.naokang.oa.common.dto.BaseViewDto;
import com.naokang.oa.common.utils.BeanUtilsExt;
import com.naokang.oa.dao.base.entity.BaseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 实体与视图DTO基础转换器，提供默认实现。
 *
 * @author liuzhe
 */
@Component
public class BaseEntityDtoConverter<E extends BaseEntity, D extends BaseViewDto>
    extends AbstractEntityDtoConverter<E, D> {

    @Override
    protected void convert2ViewDtoPostHandle(E entity, D dto) {
        // to be implement
    }

    @Override
    public Map<String, Object> convertViewDto2Map(D dto) {
        return BeanUtilsExt.beanToMap(dto, true);
    }

    @Override
    protected void convertParamDto2EntityPostHandle(BaseParamDto paramDto, E entity) {
        // to be implement
    }

}

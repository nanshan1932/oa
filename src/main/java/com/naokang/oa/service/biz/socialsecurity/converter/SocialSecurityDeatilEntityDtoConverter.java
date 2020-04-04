package com.naokang.oa.service.biz.socialsecurity.converter;

import com.naokang.oa.common.dto.BaseParamDto;
import com.naokang.oa.dao.biz.socialsecurity.entity.SocialSecurityDetailEntity;
import com.naokang.oa.service.base.converter.BaseEntityDtoConverter;
import com.naokang.oa.service.biz.socialsecurity.dto.SocialSecurityDetailViewDto;
import org.springframework.stereotype.Component;

@Component
public class SocialSecurityDeatilEntityDtoConverter extends BaseEntityDtoConverter<SocialSecurityDetailEntity, SocialSecurityDetailViewDto> {

    @Override
    protected void convert2ViewDtoPostHandle(SocialSecurityDetailEntity entity, SocialSecurityDetailViewDto dto) {
    }

    @Override
    protected void convertParamDto2EntityPostHandle(BaseParamDto paramDto, SocialSecurityDetailEntity entity) {

    }
}

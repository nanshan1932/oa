package com.naokang.oa.service.biz.staff.converter;

import com.naokang.oa.common.dto.BaseParamDto;
import com.naokang.oa.dao.biz.staff.entity.StaffEntity;
import com.naokang.oa.service.base.converter.BaseEntityDtoConverter;
import com.naokang.oa.service.biz.staff.dto.StaffViewDto;
import org.springframework.stereotype.Component;

@Component
public class StaffEntityDtoConverter extends BaseEntityDtoConverter<StaffEntity, StaffViewDto> {
    @Override
    protected void convert2ViewDtoPostHandle(StaffEntity entity, StaffViewDto dto) {
        dto.setSexTxt("男");
        dto.setEducationTxt("大专");
    }

    @Override
    protected void convertParamDto2EntityPostHandle(BaseParamDto paramDto, StaffEntity entity) {

    }
}

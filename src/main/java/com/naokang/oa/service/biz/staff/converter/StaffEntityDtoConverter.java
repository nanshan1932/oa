package com.naokang.oa.service.biz.staff.converter;

import com.naokang.oa.common.constants.VarsConstants;
import com.naokang.oa.common.dto.BaseParamDto;
import com.naokang.oa.dao.biz.staff.entity.StaffEntity;
import com.naokang.oa.service.base.converter.BaseEntityDtoConverter;
import com.naokang.oa.service.biz.dept.IDepartmentService;
import com.naokang.oa.service.biz.dictionary.IDictionaryService;
import com.naokang.oa.service.biz.staff.dto.StaffViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaffEntityDtoConverter extends BaseEntityDtoConverter<StaffEntity, StaffViewDto> {

    @Autowired
    private IDictionaryService dictionaryService;

    @Autowired
    private IDepartmentService departmentService;

    @Override
    protected void convert2ViewDtoPostHandle(StaffEntity entity, StaffViewDto dto) {
        dto.setSexTxt(dictionaryService.getDictNameByCode(entity.getSex(), VarsConstants.DictType.SEX_TYPE));
        dto.setEducationTxt(dictionaryService.getDictNameByCode(entity.getEducation(), VarsConstants.DictType.EDUCATION_TYPE));
        dto.setMaritalStatusTxt(dictionaryService.getDictNameByCode(entity.getMaritalStatus(), VarsConstants.DictType.MARITAL_STATUS_TYPE));
        dto.setPostTxt(dictionaryService.getDictNameByCode(entity.getPost(), VarsConstants.DictType.POST_TYPE));
        dto.setDepartment(departmentService.getDeptNameById(entity.getDeptId()));
    }

    @Override
    protected void convertParamDto2EntityPostHandle(BaseParamDto paramDto, StaffEntity entity) {

    }
}

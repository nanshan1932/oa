package com.naokang.oa.service.biz.staff.impl;

import com.naokang.oa.common.utils.BeanUtilsExt;
import com.naokang.oa.dao.biz.staff.entity.StaffEntity;
import com.naokang.oa.dao.biz.staff.mapper.StaffMapper;
import com.naokang.oa.service.base.converter.AbstractEntityDtoConverter;
import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.StaffSaveDto;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
import com.naokang.oa.service.biz.staff.dto.StaffViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@Service
public class StaffServiceImpl implements IStaffService {

    @Resource
    private StaffMapper staffMapper;

    @Autowired
    private AbstractEntityDtoConverter<StaffEntity, StaffViewDto> staffEntityDtoConverter;

    @Override
    public void addStaff(StaffSaveDto dto) {
        StaffEntity entity = new StaffEntity();
        BeanUtilsExt.copy(dto, entity);
        staffMapper.insertInto(entity);
    }

    @Override
    public Map<String, Object> getStaffPage(StaffSearchDto dto) {
        Map<String, Object> param = new HashMap<>(8);
        param.put("name", dto.getName());
        List<StaffEntity> staffEntities = staffMapper.selectPageEntities(param);
        Integer total = staffMapper.selectPageCount(param);

        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("pageSize", dto.getPageSize());
        resultInfo.put("pageNo", dto.getPageSize());
        resultInfo.put("totalPage", 6);
        resultInfo.put("totalCount", total);
        resultInfo.put("data", staffEntityDtoConverter.convert2ViewDtoList(staffEntities, StaffViewDto.class));
        Map<String, Object> rst = new HashMap<>(8);
        rst.put("result", resultInfo);
        return rst;
    }
}

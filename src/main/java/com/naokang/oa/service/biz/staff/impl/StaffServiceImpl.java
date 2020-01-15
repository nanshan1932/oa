package com.naokang.oa.service.biz.staff.impl;

import com.naokang.oa.dao.biz.staff.entity.StaffEntity;
import com.naokang.oa.dao.biz.staff.mapper.StaffMapper;
import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
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

    @Override
    public Map<String, Object> getStaffPage(StaffSearchDto dto) {
        Map<String, Object> param = new HashMap<>(8);
        param.put("name", dto.getName());
        List<StaffEntity> staffEntities = staffMapper.selectPageEntities(param);
        Integer total = staffMapper.selectPageCount(param);

        Map<String, Object> result = new HashMap<>(8);
        result.put("total", total);
        result.put("rows", staffEntities);
        return result;
    }
}

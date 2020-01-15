package com.naokang.oa.service.biz.staff;

import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;

import java.util.Map;

/**
 * @author wangsai
 * @data 2020/1/15
 */
public interface IStaffService {

    /**
     * 分页查询
     * @param dto
     * @return
     */
    Map<String, Object> getStaffPage(StaffSearchDto dto);
}

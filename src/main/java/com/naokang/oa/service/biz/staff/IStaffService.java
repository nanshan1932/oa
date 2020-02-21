package com.naokang.oa.service.biz.staff;

import com.naokang.oa.service.biz.staff.dto.StaffSaveDto;
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

    /**
     * 添加员工记录
     * @param dto
     */
    void addStaff(StaffSaveDto dto);

    /**
     * 修改员工信息
     * @param dto
     */
    void updateStaff(StaffSaveDto dto);
}

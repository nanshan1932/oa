package com.naokang.oa.service.biz.staff;

import com.naokang.oa.service.biz.staff.dto.StaffSaveDto;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
import com.naokang.oa.service.biz.staff.dto.StaffUploadDto;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 上传excel文件
     * @param file
     * @return
     */
    ExcelImportResult<StaffUploadDto> uploadStaffByExcel(MultipartFile file);

    /**
     * 插入excel中的文件
     * @param excelImportResult
     * @return
     */
    Map<String, Object> insertStaffByExcel(ExcelImportResult<StaffUploadDto> excelImportResult);
}

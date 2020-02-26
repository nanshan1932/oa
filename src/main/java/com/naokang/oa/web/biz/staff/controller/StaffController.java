package com.naokang.oa.web.biz.staff.controller;

import com.naokang.oa.common.constants.VarsConstants;
import com.naokang.oa.common.exception.BusinessException;
import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.StaffSaveDto;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
import com.naokang.oa.service.biz.staff.dto.StaffUploadDto;
import com.naokang.oa.web.base.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@RestController
@RequestMapping("/staff")
@Api(tags = "staff controller")
@Slf4j
public class StaffController extends AbstractController {

    @Autowired
    private IStaffService staffService;

    @ApiOperation("添加员工")
    @PostMapping(value = "/addStaff")
    public void addStaff(@Validated StaffSaveDto dto, BindingResult result){
        checkValidResult(result);
        staffService.addStaff(dto);
    }

    @ApiOperation("修改员工信息")
    @PostMapping(value = "/updateStaff")
    public void updateStaff(@Validated StaffSaveDto dto, BindingResult result){
        checkValidResult(result);
        staffService.updateStaff(dto);
    }



    @ApiOperation("分页获取员工列表")
    @GetMapping(value = "/getStaffPage")
    public Map<String, Object> getStaffPage(@Validated StaffSearchDto dto, BindingResult result) {
        checkValidResult(result);
        return staffService.getStaffPage(dto);
    }

    @ApiOperation(value = "上传调整数据")
    @PostMapping(value = "/uploadFile")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result ;
        if(file.isEmpty()){
            throw new BusinessException("文件不能为空");
        }else if((file.getOriginalFilename().endsWith(VarsConstants.ExcelType.XLS)
                || file.getOriginalFilename().endsWith(VarsConstants.ExcelType.XLSX))){
            ExcelImportResult<StaffUploadDto> excelImportResult =
                    staffService.uploadStaffByExcel(file);
            result = staffService.insertStaffByExcel(excelImportResult);
        }else {
            throw new BusinessException("只支持excel格式文件!");
        }
        return result;
    }

}

package com.naokang.oa.web.biz.staff.controller;

import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@RestController
@RequestMapping("/staff")
@Api(tags = "staff controller")
@Slf4j
public class StaffController {

    @Autowired
    private IStaffService staffService;


    @ApiOperation("分页获取礼品卡差异统计")
    @GetMapping(value = "/getStaffPage")
    public Map<String, Object> getStaffPage(@Validated StaffSearchDto dto, BindingResult result) {
        checkValidResult(result);
        return staffService.getStaffPage(dto);
    }

    private void checkValidResult(BindingResult result) {
        if (result != null && result.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errorMsg.append(error.getDefaultMessage());
            }
            throw new RuntimeException(errorMsg.toString());
        }
    }

}

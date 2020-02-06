package com.naokang.oa.web.biz.staff.controller;

import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.StaffSaveDto;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
import com.naokang.oa.web.base.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class StaffController extends AbstractController {

    @Autowired
    private IStaffService staffService;

    @ApiOperation("添加员工")
    @PostMapping(value = "/addStaff")
    public void addStaff(@Validated StaffSaveDto dto, BindingResult result){
        checkValidResult(result);
        staffService.addStaff(dto);
    }

    @ApiOperation("分页获取员工列表")
    @GetMapping(value = "/getStaffPage")
    public Map<String, Object> getStaffPage(@Validated StaffSearchDto dto, BindingResult result) {
        checkValidResult(result);
        return staffService.getStaffPage(dto);
    }

}

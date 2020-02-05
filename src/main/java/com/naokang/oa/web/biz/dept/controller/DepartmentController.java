package com.naokang.oa.web.biz.dept.controller;

import com.naokang.oa.service.biz.dept.IDepartmentService;
import com.naokang.oa.service.biz.dept.dto.DepartMentSaveDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dept")
@Api(tags = "dept controller")
@Slf4j
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @ApiOperation("获取部门列表")
    @GetMapping(value = "/deptList")
    public Map<String, Object> deptList() {
        return departmentService.getTreeDeptList();
    }

    @ApiOperation("添加部门")
    @PostMapping(value = "/addDept")
    public void addDept(@Validated DepartMentSaveDto dto, BindingResult result){
        departmentService.addDept(dto);
    }
}

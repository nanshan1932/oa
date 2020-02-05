package com.naokang.oa.service.biz.dept;

import com.naokang.oa.service.biz.dept.dto.DepartMentSaveDto;

import java.util.Map;

public interface IDepartmentService {

    Map<String, Object> getTreeDeptList();

    void addDept(DepartMentSaveDto dto);
}

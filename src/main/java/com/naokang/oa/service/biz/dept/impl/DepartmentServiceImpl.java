package com.naokang.oa.service.biz.dept.impl;

import com.naokang.oa.dao.biz.dept.entity.DepartmentEntity;
import com.naokang.oa.dao.biz.dept.mapper.DepartmentMapper;
import com.naokang.oa.service.biz.dept.IDepartmentService;
import com.naokang.oa.service.biz.dept.dto.DepartMentSaveDto;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public void addDept(DepartMentSaveDto dto) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setParentId(dto.getParentId());
        entity.setDeptName(dto.getDeptName());
        departmentMapper.insertInto(entity);
    }

    @Override
    public Map<String, Object> getTreeDeptList() {
        List<Map<String, Object>> nodeList = getDeptNodeList(0);
        Map<String, Object> ret = new HashMap<>();
        ret.put("result",nodeList);
        return ret;
    }

    private List<Map<String, Object>> getDeptNodeList(Integer rootParentId) {
        DepartmentEntity entityInfo = new DepartmentEntity();
        entityInfo.setParentId(rootParentId);
        entityInfo.setMark(0);
        List<DepartmentEntity> rootNodeList = departmentMapper.selectEntities(entityInfo);
        Assert.notNull(rootNodeList, "根节点为空！");
        return getNodeListRecursion(rootParentId);
    }

    private List<Map<String, Object>> getNodeListRecursion(Integer parentId) {
        List<Map<String, Object>> nodeList = new ArrayList<>();
        DepartmentEntity entityInfo = new DepartmentEntity();
        entityInfo.setParentId(parentId);
        entityInfo.setMark(0);
        List<DepartmentEntity> curNodeList = departmentMapper.selectEntities(entityInfo);
        if(CollectionUtils.isEmpty(curNodeList)){
            return nodeList;
        }
        for(int i = 0; i < curNodeList.size(); i++){
            DepartmentEntity node = curNodeList.get(i);
            Map<String, Object> map = new HashMap<>();
            map.put("key", node.getId());
            map.put("title", node.getDeptName());
            List<Map<String, Object>> childList = getNodeListRecursion(node.getId());
            if(!CollectionUtils.isEmpty(childList)){
                map.put("children", childList);
            }
            map.put("icon", null);
            nodeList.add(map);
        }
        return nodeList;
    }
}

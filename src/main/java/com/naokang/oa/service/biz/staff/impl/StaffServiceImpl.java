package com.naokang.oa.service.biz.staff.impl;

import com.naokang.oa.dao.biz.staff.entity.StaffEntity;
import com.naokang.oa.dao.biz.staff.mapper.StaffMapper;
import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.StaffSearchDto;
import com.naokang.oa.service.biz.staff.dto.StaffViewDto;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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

        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("pageSize", 10);
        resultInfo.put("pageNo", 0);
        resultInfo.put("totalPage", 6);
        resultInfo.put("totalCount", total);
        resultInfo.put("data", convert2ViewDtoList(staffEntities, StaffViewDto.class));
        Map<String, Object> rst = new HashMap<>(8);
        rst.put("result", resultInfo);
        return rst;
    }

    /**
     * 模板方法，实体列表转视图dto列表。<br>
     * 默认只转换名称与类型相同的字段。
     *
     * @param entityList 待转换实体列表
     * @param dtoClass dto类型
     * @return dto列表
     */
    public final List<StaffViewDto> convert2ViewDtoList(List<StaffEntity> entityList, Class<StaffViewDto> dtoClass) {
        List<StaffViewDto> dtoList = new ArrayList<>();
        if (CollectionUtils.isEmpty(entityList)) {
            return dtoList;
        }

        try {
            StaffEntity source = entityList.get(0);
            BeanCopier beanCopier = BeanCopier.create(source.getClass(), dtoClass, false);
            for (StaffEntity entity : entityList) {
                StaffViewDto dto = dtoClass.newInstance();
                beanCopier.copy(entity, dto, null);
                convert2ViewDtoPostHandle(entity, dto);
                dtoList.add(dto);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("实体列表转视图dto列表出错！", e);
        }
        return dtoList;
    }

    private void convert2ViewDtoPostHandle(StaffEntity entity, StaffViewDto dto) {
        dto.setSexTxt("男");
    }
}

package com.naokang.oa.service.biz.dictionary.impl;

import com.naokang.oa.dao.biz.dictionary.entity.DictionaryEntity;
import com.naokang.oa.dao.biz.dictionary.mapper.DictionaryMapper;
import com.naokang.oa.service.biz.dictionary.IDictionaryService;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySaveDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionaryViewDto;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryServiceImpl implements IDictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public Map<String, Object> getDictionaryPage() {
        Map<String, Object> param = new HashMap<>(8);
        param.put("mark", 0);
        List<DictionaryEntity> staffEntities = dictionaryMapper.selectPageEntities(param);
        Integer total = dictionaryMapper.selectPageCount(param);

        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("pageSize", 10);
        resultInfo.put("pageNo", 0);
        resultInfo.put("totalPage", 6);
        resultInfo.put("totalCount", total);
        resultInfo.put("data", convert2ViewDtoList(staffEntities, DictionaryViewDto.class));
        Map<String, Object> rst = new HashMap<>(8);
        rst.put("result", resultInfo);
        return rst;
    }

    @Override
    public void addDict(DictionarySaveDto dto) {
        DictionaryEntity entity = new DictionaryEntity();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setType(dto.getType());
        entity.setTypeDes(dto.getTypeDes());
        dictionaryMapper.insertInto(entity);
    }

    @Override
    public void updateDict(DictionarySaveDto dto) {
        DictionaryEntity entity = new DictionaryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setType(dto.getType());
        entity.setTypeDes(dto.getTypeDes());
        dictionaryMapper.updateInto(entity);
    }

    @Override
    public void deleteById(Integer id) {
        dictionaryMapper.deleteById(id);
    }

    /**
     * 模板方法，实体列表转视图dto列表。<br>
     * 默认只转换名称与类型相同的字段。
     *
     * @param entityList 待转换实体列表
     * @param dtoClass dto类型
     * @return dto列表
     */
    public final List<DictionaryViewDto> convert2ViewDtoList(List<DictionaryEntity> entityList, Class<DictionaryViewDto> dtoClass) {
        List<DictionaryViewDto> dtoList = new ArrayList<>();
        if (CollectionUtils.isEmpty(entityList)) {
            return dtoList;
        }

        try {
            DictionaryEntity source = entityList.get(0);
            BeanCopier beanCopier = BeanCopier.create(source.getClass(), dtoClass, false);
            for (DictionaryEntity entity : entityList) {
                DictionaryViewDto dto = dtoClass.newInstance();
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

    private void convert2ViewDtoPostHandle(DictionaryEntity entity, DictionaryViewDto dto) {
    }
}

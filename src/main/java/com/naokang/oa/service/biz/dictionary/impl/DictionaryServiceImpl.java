package com.naokang.oa.service.biz.dictionary.impl;

import com.naokang.oa.common.constants.SysConstants;
import com.naokang.oa.dao.base.mapper.IBaseMapper;
import com.naokang.oa.dao.biz.dictionary.entity.DictionaryEntity;
import com.naokang.oa.dao.biz.dictionary.mapper.DictionaryMapper;
import com.naokang.oa.service.base.converter.AbstractEntityDtoConverter;
import com.naokang.oa.service.base.impl.BaseServiceImpl;
import com.naokang.oa.service.biz.dictionary.IDictionaryService;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySaveDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySearchDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionaryViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseServiceImpl<DictionaryEntity> implements IDictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private AbstractEntityDtoConverter<DictionaryEntity, DictionaryViewDto> dictionaryEntityDtoConverter;

    @Override
    public IBaseMapper<DictionaryEntity> getMapper() {
        return dictionaryMapper;
    }

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
        resultInfo.put("data", dictionaryEntityDtoConverter.convert2ViewDtoList(staffEntities, DictionaryViewDto.class));
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
    public void deleteDictById(Integer id) {
        dictionaryMapper.deleteById(id);
    }

    @Override
    public List<DictionaryViewDto> searchDictList(DictionarySearchDto dto) {
        DictionaryEntity entityInfo = new DictionaryEntity();
        entityInfo.setType(dto.getType());
        entityInfo.setMark(SysConstants.MarkType.VALID);
        List<DictionaryEntity> entityList = dictionaryMapper.selectEntities(entityInfo);
        return dictionaryEntityDtoConverter.convert2ViewDtoList(entityList, DictionaryViewDto.class);
    }

    @Override
    public String getDictNameByCode(Integer code, Integer type) {
        DictionaryEntity entityInfo = new DictionaryEntity();
        entityInfo.setCode(code);
        entityInfo.setType(type);
        DictionaryEntity entity = selectEntity(entityInfo);
        if(entity == null){
            return "";
        }
        return entity.getName();
    }
}

package com.naokang.oa.service.biz.dictionary;

import com.naokang.oa.service.biz.dictionary.dto.DictionarySaveDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySearchDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionaryViewDto;

import java.util.List;
import java.util.Map;

public interface IDictionaryService {
    /**
     * 分页获取字典列表
     * @return
     */
    Map<String, Object> getDictionaryPage();

    /**
     * 新增字典值
     * @param dto
     */
    void addDict(DictionarySaveDto dto);

    /**
     * 更新字典值
     * @param dto
     */
    void updateDict(DictionarySaveDto dto);

    /**
     * 根据ID删除数据
     * @param id
     */
    void deleteById(Integer id);

    List<DictionaryViewDto> searchDictList(DictionarySearchDto dto);
}

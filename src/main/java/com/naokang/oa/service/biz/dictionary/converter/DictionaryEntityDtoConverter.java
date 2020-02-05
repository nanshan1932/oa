package com.naokang.oa.service.biz.dictionary.converter;

import com.naokang.oa.dao.biz.dictionary.entity.DictionaryEntity;
import com.naokang.oa.service.base.converter.BaseEntityDtoConverter;
import com.naokang.oa.service.biz.dictionary.dto.DictionaryViewDto;
import org.springframework.stereotype.Component;

@Component
public class DictionaryEntityDtoConverter extends BaseEntityDtoConverter<DictionaryEntity, DictionaryViewDto> {
}

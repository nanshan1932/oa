package com.naokang.oa.service.biz.dictionary.dto;

import com.naokang.oa.common.dto.BaseViewDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DictionaryViewDto extends BaseViewDto {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 类别
     */
    private Integer type;

    /**
     * 类别描述
     */
    private String typeDes;
}

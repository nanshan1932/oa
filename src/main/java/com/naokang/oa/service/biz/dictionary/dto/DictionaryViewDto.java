package com.naokang.oa.service.biz.dictionary.dto;

import lombok.Data;

@Data
public class DictionaryViewDto {
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

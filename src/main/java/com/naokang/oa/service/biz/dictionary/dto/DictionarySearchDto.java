package com.naokang.oa.service.biz.dictionary.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DictionarySearchDto {
    /**
     * 类别
     */
    @NotNull
    private Integer type;
}

package com.naokang.oa.dao.biz.dictionary.entity;

import com.naokang.oa.dao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 数据字典
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictionaryEntity extends BaseEntity {

    private static final long serialVersionUID = 4447086840849416673L;

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

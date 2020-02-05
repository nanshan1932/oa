package com.naokang.oa.dao.biz.dictionary.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 数据字典
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictionaryEntity {
    private static final long serialVersionUID = 1L;

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

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 操作人Id
     */
    private Integer optId;

    /**
     * 标识(是否有效 0有效；-1无效)
     */
    private Integer mark;
}

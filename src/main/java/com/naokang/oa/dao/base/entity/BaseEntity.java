package com.naokang.oa.dao.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * entity 基类
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1804409376551908855L;

    /**
     * id
     */
    private Integer id;

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

    /**
     * 初始化添加时间与修改时间
     */
    public void initAddUpdateTime() {
        setAddTime(new Date());
        setUpdateTime(new Date());
    }
}

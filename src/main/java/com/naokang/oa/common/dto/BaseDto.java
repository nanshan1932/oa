package com.naokang.oa.common.dto;

import com.naokang.oa.common.utils.BeanUtilsExt;

import java.util.Map;

/**
 * DTO顶级父类
 */
public class BaseDto {
    /**
     * 转换dto为map
     * @return map
     */
    public Map<String, Object> convertDto2Map() {
        return BeanUtilsExt.beanToMap(this, true);
    }
}

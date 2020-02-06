package com.naokang.oa.web.base.controller;

import com.naokang.oa.common.exception.BusinessException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public abstract class AbstractController {
    /**
     * 检查验证结果，如果有错误信息则抛出异常
     *
     * @param result 验证结果
     */
    protected void checkValidResult(BindingResult result) {
        if (result != null && result.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errorMsg.append(error.getDefaultMessage());
            }
            throw new BusinessException(errorMsg.toString());
        }
    }
}

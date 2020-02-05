package com.naokang.oa.common.dto;

import com.naokang.oa.common.constants.SysConstants;
import com.naokang.oa.common.utils.BeanUtilsExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Map;

/**
 * 基础参数dto
 */
@ToString
public class BaseParamDto extends BaseDto {

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 页数
     */
    private Integer pageNo;

    /**
     * 记录是否有效
     */
    @ApiModelProperty(hidden = true)
    private final Integer mark = SysConstants.MarkType.VALID;

    public Integer getPageNo() {
        return pageNo == null || pageNo <= 0 ? SysConstants.Page.PAGE_NUMBER_DEFAULT : pageNo;
    }

    public Integer getPageSize() {
        return pageSize == null ? SysConstants.Page.PAGE_SIZE_DEFAULT
                : pageSize.intValue() > SysConstants.Page.PAGE_SIZE_MAX ? SysConstants.Page.PAGE_SIZE_MAX : pageSize;
    }

    /**
     * 转换参数dto为分页查询map
     *
     * @return map，包含分页参数（pageSize，pageBegin）
     */
    public Map<String, Object> convertParamDto2PageQueryMap() {
        checkParamDto();
        Map<String, Object> paramMap = BeanUtilsExt.beanToMap(this, true);
        paramMap.put("pageBegin", computePageBegin());
        return paramMap;
    }

    /**
     * 转换参数dto为导出查询参数Map
     *
     * @return map，不包含分页参数（pageNumber，pageSize）
     */
    public Map<String, Object> convertParamDto2ExportQueryMap() {
        checkParamDto();
        Map<String, Object> map = BeanUtilsExt.beanToMap(this, true);
        map.remove("pageNumber");
        map.remove("pageSize");
        return map;
    }

    /**
     * 检查参数
     */
    protected void checkParamDto() {
        // 默认不做任何处理，如果需要请子类覆盖实现
    }

    /**
     * 计算分页查询起始位置
     *
     * @return
     */
    private Integer computePageBegin() {
        return (getPageNo() - 1) * getPageSize();
    }

}

package com.naokang.oa.service.biz.staff.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StaffResignDto {

    /**
     * 员工ID
     */
    @NotNull(message = "员工ID不能为空")
    private Integer id;

    /**
     * 离职日期
     */
    @NotNull(message = "离职日期不能为空")
    private Date resignationDate;

    @NotBlank(message = "断保月份不能为空")
    private String stopMonth;
}

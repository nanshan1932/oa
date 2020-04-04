package com.naokang.oa.web.biz.socialsecurity.controller;

import com.naokang.oa.service.biz.socialsecurity.ISocialSecurityDetailService;
import com.naokang.oa.service.biz.socialsecurity.dto.SocialSecurityDetailSearchDto;
import com.naokang.oa.web.base.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/socialSecurityDetail")
@Api(tags = "SS Detail Controller")
@Slf4j
public class SocialSecurityDetailController extends AbstractController {

    @Autowired
    private ISocialSecurityDetailService socialSecurityDetailService;

    @ApiOperation("社保分页查询")
    @GetMapping(value = "/socialSecurityList")
    public Map<String, Object> dictList(@Validated SocialSecurityDetailSearchDto dto, BindingResult result) {
        checkValidResult(result);
        return socialSecurityDetailService.getSocialSecurityPage(dto);
    }
}

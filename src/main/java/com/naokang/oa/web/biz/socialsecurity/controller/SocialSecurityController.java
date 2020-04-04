package com.naokang.oa.web.biz.socialsecurity.controller;

import com.naokang.oa.web.base.controller.AbstractController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialSecurity")
@Api(tags = "Social Security Controller")
@Slf4j
public class SocialSecurityController extends AbstractController {
}

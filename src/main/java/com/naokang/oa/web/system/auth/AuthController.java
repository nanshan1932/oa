package com.naokang.oa.web.system.auth;

import com.naokang.oa.common.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Api(tags = "auth controller")
@Slf4j
public class AuthController {

    private static final String USERNAME = "admin";

    private static final String PASSWORD = "8914de686ab28dc22f30d3d8e107ff6c";

    @ApiOperation("分页获取礼品卡差异统计")
    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody @Validated LoginDto dto, BindingResult result) {
        if(!USERNAME.equals(dto.getUsername()) || !PASSWORD.equals(dto.getPassword())){
            throw new BusinessException("用户名或者密码错误！");
        }
        Map<String, Object> rst = new HashMap<>(8);
        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("token", "4291d7da9005377ec9aec4a71ea837f");
        rst.put("result", resultInfo);
        return rst;
    }

    @ApiOperation("分页获取礼品卡差异统计")
    @PostMapping(value = "/2step-code")
    public Map<String, Object> stepCode() {
        Map<String, Object> rst = new HashMap<>(8);
        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("stepCode", "123456");
        rst.put("result", resultInfo);
        return rst;
    }
}

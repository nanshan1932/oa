package com.naokang.oa.web.biz.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangsai
 * @data 2020/1/17
 */
@RestController
@RequestMapping("/user")
@Api(tags = "auth controller")
@Slf4j
public class UserController {

    @ApiOperation("分页获取礼品卡差异统计")
    @GetMapping(value = "/info")
    public Map<String, Object> getUserInfo() {
        Map<String, Object> rst = new HashMap<>(8);
        Map<String, Object> roleInfo = new HashMap<>(8);
        roleInfo.put("id", "admin");
        roleInfo.put("name", "管理员");
        roleInfo.put("describe", "拥有所有权限");
        roleInfo.put("status", 1);
        roleInfo.put("creatorId", "system");
        roleInfo.put("createTime", "1497160610259");
        roleInfo.put("deleted", 0);
        roleInfo.put("permissions", getPermissions());
        Map<String, Object> userInfo = new HashMap<>(16);
        userInfo.put("id", "4291d7da9005377ec9aec4a71ea837f");
        userInfo.put("name", "天野远子");
        userInfo.put("username", "admin");
        userInfo.put("password", "");
        userInfo.put("avatar", "/avatar2.jpg");
        userInfo.put("status", 1);
        userInfo.put("telephone", "");
        userInfo.put("lastLoginIp", "27.154.74.117");
        userInfo.put("lastLoginTime", "1534837621348");
        userInfo.put("creatorId", "admin");
        userInfo.put("createTime", "1497160610259");
        userInfo.put("merchantCode", "TLif2btpzg079h15bk");
        userInfo.put("deleted", 0);
        userInfo.put("roleId", "admin");
        userInfo.put("role", roleInfo);


        rst.put("result", userInfo);
        return rst;
    }

    private List<Map<String, Object>> getPermissions() {
        List<Map<String, Object>> permissionsList = new ArrayList<>();
        Map<String, Object> permission = new HashMap<>(8);
        permission.put("roleId","admin");
        permission.put("permissionId","table");
        permission.put("permissionName","表格权限");
        permission.put("actions","[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"}]");

        List<Map<String, Object>> actionList = new ArrayList<>();

        Map<String, Object> action1 = new HashMap<>(8);
        action1.put("action", "add");
        action1.put("describe", "新增");
        action1.put("defaultCheck", false);
        actionList.add(action1);

        Map<String, Object> action2 = new HashMap<>(8);
        action2.put("action", "import");
        action2.put("describe", "导入");
        action2.put("defaultCheck", false);
        actionList.add(action2);

        Map<String, Object> action3 = new HashMap<>(8);
        action3.put("action", "get");
        action3.put("describe", "详情");
        action3.put("defaultCheck", false);
        actionList.add(action3);

        Map<String, Object> action4 = new HashMap<>(8);
        action4.put("action", "update");
        action4.put("describe", "修改");
        action4.put("defaultCheck", false);
        actionList.add(action4);

        permission.put("actionEntitySet",actionList);

        permissionsList.add(permission);
        return permissionsList;
    }
}

package com.naokang.oa.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@Configuration
@MapperScan(basePackages = "com.naokang.oa.dao.**.mapper")
@ComponentScan({"com.naokang.oa"})
public class OaConfiguration {
}

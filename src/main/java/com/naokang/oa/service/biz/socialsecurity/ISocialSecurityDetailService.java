package com.naokang.oa.service.biz.socialsecurity;

import com.naokang.oa.service.biz.socialsecurity.dto.SocialSecurityDetailSearchDto;

import java.util.Map;

public interface ISocialSecurityDetailService {
    /**
     * 分页查询社保
     * @return
     * @param dto
     */
    Map<String, Object> getSocialSecurityPage(SocialSecurityDetailSearchDto dto);
}

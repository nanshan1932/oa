package com.naokang.oa.service.biz.socialsecurity.impl;

import com.naokang.oa.dao.base.mapper.IBaseMapper;
import com.naokang.oa.dao.biz.socialsecurity.entity.SocialSecurityEntity;
import com.naokang.oa.dao.biz.socialsecurity.mapper.SocialSecurityMapper;
import com.naokang.oa.service.base.impl.BaseServiceImpl;
import com.naokang.oa.service.biz.socialsecurity.ISocialSecurityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("socialSecurityService")
public class SocialSecurityServiceImpl extends BaseServiceImpl<SocialSecurityEntity> implements ISocialSecurityService {

    @Resource
    private SocialSecurityMapper socialSecurityMapper;

    @Override
    public IBaseMapper<SocialSecurityEntity> getMapper() {
        return socialSecurityMapper;
    }
}

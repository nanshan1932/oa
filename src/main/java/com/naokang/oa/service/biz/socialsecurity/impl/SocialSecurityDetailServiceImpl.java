package com.naokang.oa.service.biz.socialsecurity.impl;

import com.naokang.oa.dao.base.mapper.IBaseMapper;
import com.naokang.oa.dao.biz.socialsecurity.entity.SocialSecurityDetailEntity;
import com.naokang.oa.dao.biz.socialsecurity.mapper.SocialSecurityDetailMapper;
import com.naokang.oa.service.base.converter.AbstractEntityDtoConverter;
import com.naokang.oa.service.base.impl.BaseServiceImpl;
import com.naokang.oa.service.biz.socialsecurity.ISocialSecurityDetailService;
import com.naokang.oa.service.biz.socialsecurity.dto.SocialSecurityDetailSearchDto;
import com.naokang.oa.service.biz.socialsecurity.dto.SocialSecurityDetailViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("socialSecurityDetailService")
public class SocialSecurityDetailServiceImpl extends BaseServiceImpl<SocialSecurityDetailEntity> implements ISocialSecurityDetailService {

    @Autowired
    private AbstractEntityDtoConverter<SocialSecurityDetailEntity, SocialSecurityDetailViewDto> socialSecurityDeatilEntityDtoConverter;

    @Resource
    private SocialSecurityDetailMapper socialSecurityDetailMapper;

    @Override
    public IBaseMapper<SocialSecurityDetailEntity> getMapper() {
        return socialSecurityDetailMapper;
    }

    @Override
    public Map<String, Object> getSocialSecurityPage(SocialSecurityDetailSearchDto dto) {
        List<SocialSecurityDetailEntity> ssDetailEntities = socialSecurityDetailMapper.selectPageEntities(dto.convertParamDto2PageQueryMap());
        Integer total = socialSecurityDetailMapper.selectPageCount(dto.convertParamDto2PageQueryMap());

        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("pageSize", dto.getPageSize());
        resultInfo.put("pageNo", dto.getPageNo());
        resultInfo.put("totalPage", dto.getPageSize()/dto.getPageNo());
        resultInfo.put("totalCount", total);
        resultInfo.put("data", socialSecurityDeatilEntityDtoConverter.convert2ViewDtoList(ssDetailEntities, SocialSecurityDetailViewDto.class));
        Map<String, Object> rst = new HashMap<>(8);
        rst.put("result", resultInfo);
        return rst;
    }
}

package com.naokang.oa.service.biz.staff.impl;

import com.google.common.collect.Lists;
import com.naokang.oa.common.constants.SysConstants;
import com.naokang.oa.common.constants.VarsConstants;
import com.naokang.oa.common.exception.BusinessException;
import com.naokang.oa.common.utils.BeanUtilsExt;
import com.naokang.oa.dao.base.mapper.IBaseMapper;
import com.naokang.oa.dao.biz.staff.entity.StaffEntity;
import com.naokang.oa.dao.biz.staff.mapper.StaffMapper;
import com.naokang.oa.service.base.converter.AbstractEntityDtoConverter;
import com.naokang.oa.service.base.impl.BaseServiceImpl;
import com.naokang.oa.service.biz.dept.IDepartmentService;
import com.naokang.oa.service.biz.dictionary.IDictionaryService;
import com.naokang.oa.service.biz.staff.IStaffService;
import com.naokang.oa.service.biz.staff.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.tools.ant.util.DateUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.jeecgframework.poi.excel.entity.result.ExcelVerifyHanlderResult;
import org.jeecgframework.poi.handler.inter.IExcelVerifyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;

/**
 * @author wangsai
 * @data 2020/1/15
 */
@Service
public class StaffServiceImpl extends BaseServiceImpl<StaffEntity> implements IStaffService, IExcelVerifyHandler<StaffUploadDto> {

    /**
     * 文件表头
     */
    private static final Map<String, String> STAFF_HEADER = new LinkedHashMap<>();

    static {
        STAFF_HEADER.put(VarsConstants.StaffExcel.NAME, "姓名");
        STAFF_HEADER.put(VarsConstants.StaffExcel.SEX, "性别");
        STAFF_HEADER.put(VarsConstants.StaffExcel.ID_NUMBER, "身份证号码");
        STAFF_HEADER.put(VarsConstants.StaffExcel.EDUCATION, "学历");
        STAFF_HEADER.put(VarsConstants.StaffExcel.ETHNICITY, "民族");
        STAFF_HEADER.put(VarsConstants.StaffExcel.MARITAL_STATUS, "婚姻状况");
        STAFF_HEADER.put(VarsConstants.StaffExcel.DEPARTMENT, "部门");
        STAFF_HEADER.put(VarsConstants.StaffExcel.POST, "岗位");
        STAFF_HEADER.put(VarsConstants.StaffExcel.TITLE, "职称");
        STAFF_HEADER.put(VarsConstants.StaffExcel.GRADUATE_INSTITUTION, "毕业院校");
        STAFF_HEADER.put(VarsConstants.StaffExcel.MAJOR, "专业");
        STAFF_HEADER.put(VarsConstants.StaffExcel.BIRTH_DAY, "生日");
        STAFF_HEADER.put(VarsConstants.StaffExcel.REGISTERED_PERMANENT_RESIDENCE, "户口所在地");
        STAFF_HEADER.put(VarsConstants.StaffExcel.ADDRESS, "现住址");
        STAFF_HEADER.put(VarsConstants.StaffExcel.ENTRY_DATE, "入职日期");
        STAFF_HEADER.put(VarsConstants.StaffExcel.RESIGNATION_DATE, "离职日期");
        STAFF_HEADER.put(VarsConstants.StaffExcel.TEL_NUMBER, "联系方式");
        STAFF_HEADER.put(VarsConstants.StaffExcel.CONTACT_PERSON, "紧急联系人");
        STAFF_HEADER.put(VarsConstants.StaffExcel.CONTACT_PERSON_TEL, "紧急联系人电话");
        STAFF_HEADER.put(VarsConstants.StaffExcel.CONTRACT_PERIOD, "合同期限");
        STAFF_HEADER.put(VarsConstants.StaffExcel.SS_FLAG, "是否缴纳社保");
    }

    @Autowired
    private IDictionaryService dictionaryService;

    @Autowired
    private IDepartmentService departmentService;

    @Resource
    private StaffMapper staffMapper;

    @Autowired
    private AbstractEntityDtoConverter<StaffEntity, StaffViewDto> staffEntityDtoConverter;

    @Override
    public IBaseMapper<StaffEntity> getMapper() {
        return staffMapper;
    }

    @Override
    public void addStaff(StaffSaveDto dto) {
        StaffEntity entity = new StaffEntity();
        BeanUtilsExt.copy(dto, entity);
        staffMapper.insertInto(entity);
    }

    @Override
    public void updateStaff(StaffSaveDto dto) {
        StaffEntity entity = new StaffEntity();
        BeanUtilsExt.copy(dto, entity);
        updateInto(entity);
    }

    @Override
    public void resign(StaffResignDto dto) {
        String stopMonth = dto.getStopMonth();
        log.info("断保月份：{}", stopMonth);
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setId(dto.getId());
        staffEntity.setJobFlag(SysConstants.MarkType.INVALID);
        staffEntity.setResignationDate(dto.getResignationDate());
        updateInto(staffEntity);
        //todo 社保信息更新
    }

    @Override
    public Map<String, Object> getStaffPage(StaffSearchDto dto) {
        List<StaffEntity> staffEntities = staffMapper.selectPageEntities(dto.convertParamDto2PageQueryMap());
        Integer total = staffMapper.selectPageCount(dto.convertParamDto2PageQueryMap());

        Map<String, Object> resultInfo = new HashMap<>(8);
        resultInfo.put("pageSize", dto.getPageSize());
        resultInfo.put("pageNo", dto.getPageNo());
        resultInfo.put("totalPage", dto.getPageSize()/dto.getPageNo());
        resultInfo.put("totalCount", total);
        resultInfo.put("data", staffEntityDtoConverter.convert2ViewDtoList(staffEntities, StaffViewDto.class));
        Map<String, Object> rst = new HashMap<>(8);
        rst.put("result", resultInfo);
        return rst;
    }


    @Override
    public ExcelImportResult<StaffUploadDto> uploadStaffByExcel(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            long start = System.currentTimeMillis();
            log.info("解析文件（{}）开始.", file.getOriginalFilename());
            ImportParams params = new ImportParams();
            params.setNeedVerfiy(true);
            params.setVerifyHanlder(this);
            ExcelImportResult<StaffUploadDto> excelImportResult = ExcelImportUtil.importExcelVerify(inputStream, StaffUploadDto.class, params);
            log.info("解析文件（{}）结束，耗时{}ms.", file.getOriginalFilename(), System.currentTimeMillis() - start);
            return excelImportResult;
        } catch (Exception e) {
            log.warn("读取excel格式文件报错:{}", e.getMessage());
            throw new BusinessException("解析excel出错,错误消息为" + e.getMessage());
        }
    }

    @Override
    public Map<String, Object> insertStaffByExcel(ExcelImportResult<StaffUploadDto> excelImportResult) {
        Date start = new Date();
        log.info("存储上传Excel员工信息开始,开始时间{}", DateUtils.format(start, "yyyy-MM-dd HH:mm:ss"));
        List<StaffUploadDto> list = excelImportResult.getList();
        Row row = excelImportResult.getWorkbook().getSheetAt(0).getRow(0);
        headCheckByExcel(row);
        Map<String, Object> map = new HashMap<>(2);
        List<StaffEntity> excelEntities = new ArrayList<>();
        for (StaffUploadDto dto : list) {
            StaffEntity entity = new StaffEntity();
            BeanUtilsExt.copy(dto, entity);
            excelEntities.add(entity);
        }
        // 批量插入
        Lists.partition(excelEntities, VarsConstants.UPLOAD_BATCH_HUNDRED).forEach(staffMapper::insertBatch);
        map.put("totalNum", list.size());
        Date end = new Date();
        log.info("存储上传Excel积分差异结束,结束时间{},写入{}条,共耗时{}秒",
                DateUtils.format(end, "yyyy-MM-dd HH:mm:ss"),
                excelEntities.size());
        return map;
    }

    /**
     * 检查excel格式文件文件头
     *
     * @param row excel行
     */
    private void headCheckByExcel(Row row) {
        boolean hasError = false;
        Integer i = 0;
        for (String str : STAFF_HEADER.keySet()) {
            if (!STAFF_HEADER.get(str).equals(row.getCell(i).getStringCellValue())) {
                hasError = true;
                break;
            }
            i++;
        }
        if (hasError) {
            throw new BusinessException("文件格式有误，请下载最新模板，重新导入！");
        }
    }

    @Override
    public ExcelVerifyHanlderResult verifyHandler(StaffUploadDto staffUploadDto) {
        log.info("开始校验excel上传文件");
        String sexTxt = StringUtils.trim(staffUploadDto.getSexTxt());
        staffUploadDto.setSex(dictionaryService.getDictCodeByName(sexTxt, VarsConstants.DictType.SEX_TYPE));
        String educationTxt = StringUtils.trim(staffUploadDto.getEducationTxt());
        staffUploadDto.setEducation(dictionaryService.getDictCodeByName(educationTxt, VarsConstants.DictType.EDUCATION_TYPE));
        String maritalStatusTxt = StringUtils.trim(staffUploadDto.getMaritalStatusTxt());
        staffUploadDto.setMaritalStatus(dictionaryService.getDictCodeByName(maritalStatusTxt, VarsConstants.DictType.MARITAL_STATUS_TYPE));
        String postTxt = StringUtils.trim(staffUploadDto.getPostTxt());
        staffUploadDto.setPost(dictionaryService.getDictCodeByName(postTxt, VarsConstants.DictType.POST_TYPE));
        String ssFlagTxt = StringUtils.trim(staffUploadDto.getSsFlagTxt());
        staffUploadDto.setSsFlag(dictionaryService.getDictCodeByName(ssFlagTxt, VarsConstants.DictType.YES_NO_TYPE));
        String department = StringUtils.trim(staffUploadDto.getDepartment());
        staffUploadDto.setDeptId(departmentService.getDeptIdByName(department));
        ExcelVerifyHanlderResult result = new ExcelVerifyHanlderResult();
        result.setSuccess(true);
        return result;
    }
}

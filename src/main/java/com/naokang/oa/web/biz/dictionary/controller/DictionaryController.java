package com.naokang.oa.web.biz.dictionary.controller;

import com.naokang.oa.service.biz.dictionary.IDictionaryService;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySaveDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionarySearchDto;
import com.naokang.oa.service.biz.dictionary.dto.DictionaryViewDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dict")
@Api(tags = "dict controller")
@Slf4j
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @ApiOperation("获取字典列表")
    @GetMapping(value = "/dictList")
    public Map<String, Object> dictList() {
        return dictionaryService.getDictionaryPage();
    }

    @ApiOperation("获取字典列表")
    @GetMapping(value = "/searchDictList")
    public List<DictionaryViewDto> searchDictList(DictionarySearchDto dto) {
        return dictionaryService.searchDictList(dto);
    }

    @ApiOperation("添加字典值")
    @PostMapping(value = "/addDict")
    public void addDict(@Validated DictionarySaveDto dto, BindingResult result){
        dictionaryService.addDict(dto);
    }

    @ApiOperation("更新字典值")
    @PostMapping(value = "/updateDict")
    public void updateDict(@Validated DictionarySaveDto dto, BindingResult result){
        dictionaryService.updateDict(dto);
    }

    @ApiOperation("删除字典值")
    @PostMapping(value = "/deleteDict")
    public void deleteDict(@Validated DictionarySaveDto dto, BindingResult result){
        dictionaryService.deleteDictById(dto.getId());
    }
}

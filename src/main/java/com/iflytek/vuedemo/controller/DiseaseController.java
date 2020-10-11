package com.iflytek.vuedemo.controller;

import com.iflytek.vuedemo.pojo.Disease;
import com.iflytek.vuedemo.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;


    @GetMapping("/api/disease")
    public List<Disease> list() throws Exception{
        return diseaseService.list();
    }


    @PostMapping("/api/deldisease")
    public void deleteDiseaseById (@RequestBody Disease disease) throws Exception{
        diseaseService.deleteById(disease.getId());
    }


    @PostMapping("/api/disease")
    public Disease addOrUpdate(@RequestBody Disease disease) throws Exception{
        diseaseService.addOrUpdate(disease);
        return disease;
    }


    @GetMapping("/api/searchDisease")
    public List<Disease> searchResult(@RequestParam("keywords") String keywords){
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return diseaseService.list();
        } else {
            return diseaseService.Search(keywords);
        }
    }
}

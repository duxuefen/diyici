package com.iflytek.vuedemo.controller;

//先把根据一个症状查疾病做出来，然后再试试看能不能接受多个症状查疾病
//2.根据疾病查药品 ，输入一个疾病，查到多个药品

import com.iflytek.vuedemo.dao.SymptomDao;
import com.iflytek.vuedemo.pojo.Medicine;
import com.iflytek.vuedemo.service.MedicineService;
import com.iflytek.vuedemo.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AiuiController {

    @Autowired
    MedicineService medicineService;
    @Autowired
    SymptomService symptomService;

    //根剧病查药
    @RequestMapping("medicinebydisease")
    public List<Medicine> getbydisease(String name){
        return medicineService.getByDisease(name);
    }


    //根据药品名字实现的模糊查询
    @RequestMapping("getbyMedicine")
    public List<Medicine> getbyMedicine(String name){
        System.out.println(medicineService.getByNameLike(name));
        return medicineService.getByNameLike(name);
    }


    //根据症状查疾病

    @RequestMapping("getDiseasesBySymptom")
    public List<String> getDiseasesBySymptom(String name){
        System.out.println(symptomService.getDiseaseBySymptom(name));
        return symptomService.getDiseaseBySymptom(name);
    }

}




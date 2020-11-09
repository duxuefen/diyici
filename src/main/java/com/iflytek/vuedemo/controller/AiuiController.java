package com.iflytek.vuedemo.controller;

//先把根据一个症状查疾病做出来，然后再试试看能不能接受多个症状查疾病
//2.根据疾病查药品 ，输入一个疾病，查到多个药品

import com.iflytek.vuedemo.dao.SymptomDao;
import com.iflytek.vuedemo.pojo.Disease;
import com.iflytek.vuedemo.pojo.Hospital;
import com.iflytek.vuedemo.pojo.Medicine;
import com.iflytek.vuedemo.pojo.Symptom;
import com.iflytek.vuedemo.service.DiseaseService;
import com.iflytek.vuedemo.service.HospitalService;
import com.iflytek.vuedemo.service.MedicineService;
import com.iflytek.vuedemo.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class AiuiController {

    @Autowired
    MedicineService medicineService;
    @Autowired
    SymptomService symptomService;
    @Autowired
    DiseaseService diseaseService;
    @Autowired
    HospitalService hospitalService;

//    //根剧病查药
//    @RequestMapping("/api/medicinebydisease")
//    public List<Medicine> getbydisease(String name){
//        return medicineService.getByDisease(name);
//    }
//
//
//    //根据药品名字实现的模糊查询
//    @RequestMapping("/api/querymedicineByName")
//    public List<Medicine> getbyMedicine(String name){
//        System.out.println(medicineService.getByNameLike(name));
//        return medicineService.getByNameLike(name);
//    }


//    //根据症状查疾病
//
//    @RequestMapping("/api/querydiseaseBySymptom")
//    public List<String> getDiseasesBySymptom(String name){
//        System.out.println(symptomService.getDiseaseBySymptom(name));
//        return symptomService.getDiseaseBySymptom(name);
//    }

    //根剧病查药
    @RequestMapping("/api/querymedicineByDisease")
    public List<Medicine> getbydisease(String names){
        List<Medicine> list = new ArrayList<>();
        List<Medicine> medicines =new ArrayList<>();
        String name=names.split(",")[0];
        System.out.println(medicineService.getByDisease(name));
        list.addAll(medicineService.getByDisease(name));
        if (list.size()>=3){
            for (int i=0;i<3;i++){
                medicines.add(list.get(i));
            }
            return medicines;
        }else {
            return list;
        }

    }


    //根据药品名字实现的模糊查询
    @RequestMapping("/api/querymedicineByName")
    public List<Medicine> getbyMedicine(String names){
        String [] nameArray=names.split("，");
        for (String name:nameArray){
            System.out.println(name);
        }
        List<Medicine> list=new ArrayList<>();
        for (String name:nameArray){
            List<Medicine> byNameLike = medicineService.getByNameLike(name);
            for (Medicine medicine:byNameLike){
                list.add(medicine);
            }
        }
        System.out.println(list);
        return list;
    }

    //根据多个症状查询
    @RequestMapping("/api/querydiseaseBySymptom")
    public List<Symptom> getDiseasesBySymptom(String names){
        List<Symptom> list = new ArrayList<>();
        List<Symptom> symptoms =new ArrayList<>();
        String[] name=names.split(",");
        System.out.println(symptomService.getgetDiseaseBySymptoms(name));
        list.addAll(symptomService.getgetDiseaseBySymptoms(name));
        if (list.size()>=3){
            for (int i=0;i<3;i++){
                symptoms.add(list.get(i));
            }
            return symptoms;
        }else {
            return list;
        }
    }

    @RequestMapping("/api/queryhospitalByDisease")
    public List<Hospital> getHospitalByDisease(String names){
        String [] nameArray=names.split("，");
        List<Hospital> list = new ArrayList<>();
        for(String name:nameArray){
            list.addAll(hospitalService.queryHospital(name));
        }
        return list;
    }

    //药品表数据处理
    @GetMapping("/api/dispose")
    public List<Medicine> getDispose() throws Exception{
        List<Medicine> list = new ArrayList<>();
        List<Disease> diseases = new ArrayList<>();
        list.addAll(medicineService.list());
        for (Medicine medicine:list){
            String s=medicine.getCover().replace("/static","./static");
//            medicine.setCover("http://localhost:8443/api/file/"+medicine.getCover());
            medicine.setCover(s);
            diseases.addAll(diseaseService.exactSearch(medicine.disease));
            if(diseases.size()!=0) {
                medicine.setDisnumber(diseases.get(0).disnumber);
                medicine.setDepartment(diseases.get(0).department);
                medicineService.addOrUpdate(medicine);
                diseases.clear();
            }
        }
        return list;
    }
}




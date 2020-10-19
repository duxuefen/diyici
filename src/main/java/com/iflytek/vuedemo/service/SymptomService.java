package com.iflytek.vuedemo.service;

import com.iflytek.vuedemo.dao.SymptomDao;
import com.iflytek.vuedemo.pojo.Disease;
import com.iflytek.vuedemo.pojo.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class SymptomService {
    @Autowired
    SymptomDao symptomDao;

    public List<Symptom> list(){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return symptomDao.findAll(sort);
    }

    public List<Symptom> Search (String disease){
     return symptomDao.findAllByDiseaseLike(disease);
    }

    public void deleteById(int id){
        symptomDao.deleteById(id);
    }

    public void addOrUpdate(Symptom symptom){
        symptomDao.save(symptom);
    }



    //返回病的名称
    public List<String> getDiseaseBySymptom(String name){
        List<Symptom> list=symptomDao.findBySymptom(name);
        List<String> diseases=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            String disease=list.get(i).getDisease();
            System.out.println("_---------->"+disease);
            diseases.add(disease);
        }

        return diseases;
    }

    //根据多种症状返回病的名称
    public List<String> getgetDiseaseBySymptoms(String [] names){
        List<String> diseases=new ArrayList<>();//那个总的字符串
        for(String s:names){
            List<Symptom> list=new ArrayList<>();
            list=symptomDao.findBySymptom(s);
            for (int i=0;i<list.size();i++){
                String disease=list.get(i).getDisease();
                System.out.println("_---------->"+disease);
                diseases.add(disease);
            }
        }

        //去重
        HashSet set = new HashSet(diseases);
        //使用LinkedHashSet可以保证输入的顺序
        //LinkedHashSet<String> set2 = new LinkedHashSet<String>(list);
        diseases.clear();
        diseases.addAll(set);
        return diseases;
    }
 }

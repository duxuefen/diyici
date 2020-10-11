package com.iflytek.vuedemo.service;

import com.iflytek.vuedemo.dao.SymptomDao;
import com.iflytek.vuedemo.pojo.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}

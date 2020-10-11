package com.iflytek.vuedemo.service;

import com.iflytek.vuedemo.dao.DiseaseDao;
import com.iflytek.vuedemo.pojo.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    @Autowired
    DiseaseDao diseaseDao;

    public List<Disease> list(){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return diseaseDao.findAll(sort);
    }

    public void addOrUpdate(Disease disease){
        diseaseDao.save(disease);
    }

    public void deleteById(int id){
        diseaseDao.deleteById(id);
    }

    public List<Disease> Search(String keywords){
        return diseaseDao.findAllByDiseaseLike('%' + keywords + '%');
    }

}

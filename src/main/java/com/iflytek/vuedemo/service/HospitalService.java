package com.iflytek.vuedemo.service;


import com.iflytek.vuedemo.dao.HospitalDao;
import com.iflytek.vuedemo.pojo.Doctor;
import com.iflytek.vuedemo.pojo.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    HospitalDao hospitalDao;
    public List<Hospital> list(){
//      Sort sort = new Sort(Sort.Direction.DESC, "id");
        return hospitalDao.findAll();
    }
    public Hospital insert(Hospital hospital){
        return hospitalDao.save( hospital);
    }
    public List<Hospital> query(String hospital){
        return hospitalDao.findAllByHospitalLike(hospital);
    }
    public void delete(Integer id){
         hospitalDao.deleteById(id);
    }
    public Hospital insertorupdate(Hospital hospital){
        return hospitalDao.save( hospital);
    }
}

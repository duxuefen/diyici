package com.iflytek.vuedemo.service;


import com.iflytek.vuedemo.dao.DoctotDao;
import com.iflytek.vuedemo.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctotDao doctotDao;

    public List<Doctor> list(){
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return doctotDao.findAll();
    }

    public void delete(Integer id){
        doctotDao.deleteById(id);
    }

    public Doctor insert(Doctor doctor){
       return doctotDao.save( doctor);
    }
    public List <Doctor> query(String doctor){
        return  doctotDao.findAllByDoctorLike(doctor);
    }
    public List<Doctor> queryDoctor(String disease){return doctotDao.findAllByDisease(disease);}
}

package com.iflytek.vuedemo.dao;
import com.iflytek.vuedemo.pojo.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctotDao extends JpaRepository<Doctor,Integer> {
    @Override
    List<Doctor> findAll();

    void deleteById(Integer id);

    List<Doctor> findAllByDoctorLike(String doctor);



}

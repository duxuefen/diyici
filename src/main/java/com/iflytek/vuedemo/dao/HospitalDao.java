package com.iflytek.vuedemo.dao;


import com.iflytek.vuedemo.pojo.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalDao extends JpaRepository<Hospital,Integer> {

    List<Hospital> findAllByHospitalLike(String hospital);
    List<Hospital> findAllByDisease(String disease);

}

package com.iflytek.vuedemo.dao;

import com.iflytek.vuedemo.pojo.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseDao extends JpaRepository<Disease,Integer> {
    List<Disease> findAllByDiseaseLike(String keyword1);




}

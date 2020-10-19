package com.iflytek.vuedemo.dao;

import com.iflytek.vuedemo.pojo.Disease;
import com.iflytek.vuedemo.pojo.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SymptomDao extends JpaRepository<Symptom,Integer> {
    List<Symptom> findAllByDiseaseLike(String disease);
    List<Symptom> findAllBySymptom(Symptom Symptom);

    List<Symptom> findBySymptom(String symptomName);



}

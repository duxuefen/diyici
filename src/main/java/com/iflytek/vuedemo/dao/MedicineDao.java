package com.iflytek.vuedemo.dao;

import com.iflytek.vuedemo.pojo.Disease;
import com.iflytek.vuedemo.pojo.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineDao extends JpaRepository<Medicine,Integer> {
    List<Medicine> findAllByMedicineLike(String keyword);
}

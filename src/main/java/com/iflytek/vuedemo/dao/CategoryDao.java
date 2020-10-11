package com.iflytek.vuedemo.dao;

import com.iflytek.vuedemo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}

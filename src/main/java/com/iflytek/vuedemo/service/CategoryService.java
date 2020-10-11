package com.iflytek.vuedemo.service;

import com.iflytek.vuedemo.dao.CategoryDao;
import com.iflytek.vuedemo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
//        表示通过id进行降序排序，将DESC换成ASC则表示升序，将id换成其他User对象的属性后，则通过其他字段排序。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id){
//        当optional值不存在时，调用orElse()返回orElse()的参数，如果optional的值存在时返回optional的值
        Category c = categoryDao.findById(id).orElse(null);
        return c;
    }
}

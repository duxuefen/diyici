package com.iflytek.vuedemo.service;

import com.iflytek.vuedemo.dao.MedicineDao;
import com.iflytek.vuedemo.pojo.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    MedicineDao medicineDao;

    public List<Medicine> list(){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return medicineDao.findAll(sort);
    }

    public void addOrUpdate(Medicine medicine){
        medicineDao.save(medicine);
    }

    public void deleteById(int id){
        medicineDao.deleteById(id);
    }

    public List<Medicine> SeachByMedicine(String keywords){
        return medicineDao.findAllByMedicineLike('%' + keywords + '%');
    }

    //根据病的名称查药品
    public List<Medicine> getByDisease(String name ){
        return medicineDao.findByDisease(name);
    }


    //根据给的药的名字模糊查询
    public List<Medicine> getByNameLike(String name ){
        return medicineDao.findByMedicineLike("%"+name+"%");
    }

}

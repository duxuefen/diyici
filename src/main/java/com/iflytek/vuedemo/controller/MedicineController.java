package com.iflytek.vuedemo.controller;

import com.iflytek.vuedemo.pojo.Medicine;
import com.iflytek.vuedemo.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @GetMapping("/api/medicine")
    public List<Medicine> list() throws Exception{
        return medicineService.list();
    }

    @PostMapping("/api/medicine")
    public Medicine addOrUpdateMedicine(@RequestBody Medicine medicine){
        medicineService.addOrUpdate(medicine);
        return medicine;
    }

    @PostMapping("/api/delmedicine")
    public void deleteMedicineById(@RequestBody Medicine medicine){
        medicineService.deleteById(medicine.getId());
    }

    @GetMapping("/api/searchMedicine")
    public List<Medicine> searchMedicineResult(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)) {
            return medicineService.list();
        } else {
            return medicineService.SeachByMedicine(keywords);
        }
    }
}

package com.iflytek.vuedemo.controller;



import com.iflytek.vuedemo.pojo.Doctor;
import com.iflytek.vuedemo.pojo.Hospital;
import com.iflytek.vuedemo.pojo.Page;
import com.iflytek.vuedemo.result.Result;
import com.iflytek.vuedemo.service.DoctorService;
import com.iflytek.vuedemo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

//    @RequestMapping("")
//    public Result query() {
//        List<Hospital> list = hospitalService.list();
//        System.out.println(list);
//        Page page = new Page();
//        page.setData(list);
//        return Result.SUCCESS(page);
//    }


//    @Autowired
//    private DoctorService doctorService;

    @RequestMapping("/api/hospital")
    public Result query() {
        List<Hospital> list = hospitalService.list();

        Page page = new Page();
        page.setData(list);
        return Result.SUCCESS(page);
    }

    @DeleteMapping("/api/delHospital/{id}")
    public Result delete(@PathVariable Integer id) {
        Hospital hospital = new Hospital();
        hospitalService.delete(id);
        return Result.SUCCESS("删除成功");
    }

    @PostMapping("/api/hospital/insert")
    public Result add(@RequestBody Hospital hospital) {

        hospitalService.insert(hospital);
        return Result.SUCCESS("添加成功");

    }

    @GetMapping("/api/searchHospital")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return query();
        } else {
            List<Hospital> list = hospitalService.query(keywords);
            System.out.println(list);
            Page page = new Page();
            page.setData(list);
            return Result.SUCCESS(page);
        }
    }



}

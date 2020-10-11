package com.iflytek.vuedemo.controller;


import com.iflytek.vuedemo.pojo.Disease;
import com.iflytek.vuedemo.pojo.Doctor;
import com.iflytek.vuedemo.pojo.Hospital;
import com.iflytek.vuedemo.pojo.Page;
import com.iflytek.vuedemo.result.Result;
import com.iflytek.vuedemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DoctotController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/api/doctor")
    public Result query() {
        List<Doctor> list = doctorService.list();

        Page page = new Page();
        page.setData(list);
        return Result.SUCCESS(page);
    }

    @DeleteMapping("/api/deldoctor/{id}")
    public Result delete(@PathVariable Integer id) {
        Doctor doctor = new Doctor();
        doctorService.delete(id);
        return Result.SUCCESS("删除成功");
    }

    @PostMapping("/api/doctor/insert")
    public Result add(@RequestBody Doctor doctor) {

        doctorService.insert(doctor);
        return Result.SUCCESS("添加成功");

    }

    @GetMapping("/api/searchDoctor")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return query();
        } else {
            List<Doctor> list = doctorService.query(keywords);
            System.out.println(list);
            Page page = new Page();
            page.setData(list);
            return Result.SUCCESS(page);
        }
    }


}
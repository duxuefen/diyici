package com.iflytek.vuedemo.controller;

import com.iflytek.vuedemo.pojo.Symptom;
import com.iflytek.vuedemo.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SymptomController {
    @Autowired
    SymptomService symptomService;

    @GetMapping("/api/symptom")
    public List<Symptom> symptomList(){
        return symptomService.list();
    }

    @PostMapping("/api/symptom")
    public Symptom addOrUpdateSymptom(@RequestBody Symptom symptom){
        symptomService.addOrUpdate(symptom);
        return symptom;
    }

    @GetMapping("/api/searchSymptom")
    public List<Symptom> searchSymptomResult(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)) {
            return symptomService.list();
        } else {
            return symptomService.Search(keywords);
        }
    }

    @CrossOrigin
    @PostMapping("/api/delSymptom")
    public void deleteSymptomById (@RequestBody Symptom symptom) throws Exception{
        symptomService.deleteById(symptom.getId());
    }
}

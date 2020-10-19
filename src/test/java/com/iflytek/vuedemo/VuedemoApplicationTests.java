package com.iflytek.vuedemo;

import com.iflytek.vuedemo.service.SymptomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VuedemoApplicationTests {

    @Autowired
    SymptomService symptomService;
    @Test
    void contextLoads() {
    }

    @Test
    void s(){
        String [] names={"头疼","咳嗽"};
        System.out.println(symptomService.getgetDiseaseBySymptoms(names));
    }

}

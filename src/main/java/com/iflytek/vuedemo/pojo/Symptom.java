package com.iflytek.vuedemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "symptom")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    public String disease;
    public Integer disnumber;
    public String symptom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Integer getDisnumber() {
        return disnumber;
    }

    public void setDisnumber(Integer disnumber) {
        this.disnumber = disnumber;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", disease='" + disease + '\'' +
                ", disnumber=" + disnumber +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}

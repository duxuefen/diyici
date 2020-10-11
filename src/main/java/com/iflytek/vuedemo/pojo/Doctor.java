package com.iflytek.vuedemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "doctor")
//去除多余属性
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    String doctor;
    Integer disnumber;
    String hospital;
    String disease;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Integer getDisnumber() {
        return disnumber;
    }

    public void setDisnumber(Integer disnumber) {
        this.disnumber = disnumber;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctor='" + doctor + '\'' +
                ", disnumber=" + disnumber +
                ", hospital='" + hospital + '\'' +
                '}';
    }
}

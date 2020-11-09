package com.iflytek.vuedemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
//去除多余属性
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    String hospital;
    Integer disnumber;
    String disease;
    String site;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Integer getDisnumber() {
        return disnumber;
    }

    public void setDisnumber(Integer disnumber) {
        this.disnumber = disnumber;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}

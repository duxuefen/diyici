package com.iflytek.vuedemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "disease")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    public String disease;
    public Integer disnumber;
    public String department;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

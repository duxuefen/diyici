package com.iflytek.vuedemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "medicine")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    public String medicine;
    public Integer disnumber;
    public String disease;
    public String department;
    public String cover;
    public Float price;
    public String status;
    public String abs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicine='" + medicine + '\'' +
                ", disnumber=" + disnumber +
                ", disease='" + disease + '\'' +
                ", department='" + department + '\'' +
                ", cover='" + cover + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", abs='" + abs + '\'' +
                '}';
    }
}

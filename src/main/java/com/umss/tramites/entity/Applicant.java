package com.umss.tramites.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Applicant {
    @Schema(name = "id", description = "Applicant unique identifier")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(name = "ci", description = "Applicant identifier")
    private int ci;

    @Schema(name = "name", description = "Applicant name")
    private String name;

    @Schema(name = "fatherLastName", description = "Applicant father last name")
    private String fatherLastName;

    @Schema(name = "motherLastName", description = "Applicant mother last name")
    private String motherLastName;

    @Schema(name = "email", description = "Applicant email")
    private String email;

    @Schema(name = "cellphone", description = "Applicant cell phone")
    private int cellphone;

    @Schema(name = "phone", description = "Applicant phone number")
    private int phone;

    public Applicant() {
    }

    public Applicant(int ci, String name, String fatherLastName, String motherLastName, String email, int cellphone,
                     int phone) {
        this.ci = ci;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.email = email;
        this.cellphone = cellphone;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

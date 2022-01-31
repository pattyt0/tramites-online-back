package com.umss.tramites.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ApplicantDto {

    @NotBlank
    private String nombre;
    @Min(0)
    private Float precio;

    public ApplicantDto() {
    }

    public ApplicantDto(@NotBlank String nombre, @Min(0) Float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

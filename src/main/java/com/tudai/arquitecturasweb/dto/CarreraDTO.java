package com.tudai.arquitecturasweb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarreraDTO {
    private int id;
    private String nombre;
    private int duracion;
    private int cantInscriptos;

    public CarreraDTO(int id, String nombre, int duracion, int cantInscriptos) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.cantInscriptos = cantInscriptos;
    }

    public CarreraDTO() {}
}

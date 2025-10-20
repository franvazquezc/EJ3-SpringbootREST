package com.tudai.arquitecturasweb.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class IdAlumnoCarrera implements Serializable {
    @Column(name = "dni")
    private int dni;
    @Column(name = "id")
    private int id;

    public IdAlumnoCarrera(int dni, int id) {
        this.dni = dni;
        this.id = id;
    }

    public IdAlumnoCarrera(){}
}

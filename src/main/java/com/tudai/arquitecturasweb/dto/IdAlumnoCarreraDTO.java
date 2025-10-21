package com.tudai.arquitecturasweb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IdAlumnoCarreraDTO {
    private int dniAlumno;
    private int idCarrera;

    public IdAlumnoCarreraDTO(int dniAlumno, int idCarrera) {
        this.dniAlumno = dniAlumno;
        this.idCarrera = idCarrera;
    }

    public IdAlumnoCarreraDTO() {}
}

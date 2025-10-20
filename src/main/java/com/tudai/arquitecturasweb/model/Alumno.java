package com.tudai.arquitecturasweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Alumno {
    @Id
    @Column(nullable = false)
    private int dni;
    @Column(nullable = false)
    private int lu;
    @Column(nullable = false,length = 255)
    private String nombre;
    @Column(nullable = false,length = 255)
    private String apellido;
    @Column(nullable = false)
    private int edad;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false,length = 255)
    private String ciudadResidencia;
    @OneToMany(mappedBy = "alumno")
    @JsonIgnore
    private List<AlumnoCarrera> carreras;

    public Alumno(int dni,int lu,String nombre,String apellido,int edad,String genero,String ciudadResidencia) {
        this.dni = dni;
        this.lu = lu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero=genero;
        this.ciudadResidencia = ciudadResidencia;
        this.carreras = new ArrayList<>();
    }

    public Alumno() {}

    @Override
    public String toString() {
        return "Alumno{" +
                "dni=" + dni +
                ", lu=" + lu +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                '}';
    }
}

package com.tudai.arquitecturasweb;

import com.tudai.arquitecturasweb.utils.LoadCSV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Ej3SpringbootRestApplication {

    public static void main(String[] args) throws IOException {
        LoadCSV cargarCSV = new LoadCSV();
        cargarCSV.LoadCarrera();
        cargarCSV.LoadAlumno();
        cargarCSV.LoadAlumnoCarrera();
        SpringApplication.run(Ej3SpringbootRestApplication.class, args);
    }

}

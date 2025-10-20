package com.tudai.arquitecturasweb;

import com.tudai.arquitecturasweb.utils.LoadCSV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Ej3SpringbootRestApplication {

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext context = SpringApplication.run(Ej3SpringbootRestApplication.class, args);


        LoadCSV cargarCSV = context.getBean(LoadCSV.class);
        cargarCSV.LoadCarrera();
        cargarCSV.LoadAlumno();
        cargarCSV.LoadAlumnoCarrera();
    }

}

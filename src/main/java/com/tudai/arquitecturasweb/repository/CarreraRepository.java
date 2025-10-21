package com.tudai.arquitecturasweb.repository;

import com.tudai.arquitecturasweb.dto.CarreraDTO;
import com.tudai.arquitecturasweb.model.Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    @Query("SELECT new com.tudai.arquitecturasweb.dto.CarreraDTO(c.id, c.nombre, c.duracion, CAST(SIZE(c.inscriptos) AS int)) " +
            "FROM Carrera c " +
            "WHERE SIZE(c.inscriptos) > 0 " +
            "ORDER BY SIZE(c.inscriptos) DESC")
    List<CarreraDTO> getCarrerasOrderByCantAlumnos();

    @Query("SELECT new com.tudai.arquitecturasweb.dto.CarreraDTO(c.id, c.nombre, c.duracion, CAST(SIZE(c.inscriptos) AS int)) " +
            "FROM Carrera c " +
            "ORDER BY c.nombre ASC")
    List<CarreraDTO> getAllOrderByNombre();
}

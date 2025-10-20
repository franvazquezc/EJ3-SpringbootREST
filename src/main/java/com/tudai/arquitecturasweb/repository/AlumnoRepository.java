package com.tudai.arquitecturasweb.repository;

import com.tudai.arquitecturasweb.dto.AlumnoDTO;
import com.tudai.arquitecturasweb.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Query("SELECT new dto.AlumnoDTO(a.dni, a.nombre, a.apellido, a.edad, a.genero, a.ciudadResidencia, a.lu) " +
            "FROM AlumnoCarrera ac " +
            "JOIN ac.alumno a " +
            "JOIN ac.carrera c " +
            "WHERE c.id = :idCarrera AND a.ciudadResidencia = :ciudad")
    public List<AlumnoDTO> getAlumnoByCarreraAndCiudad(int idCarrera, String ciudad);

    @Query("SELECT a FROM Alumno a WHERE a.lu = :lu")
    public AlumnoDTO getAlumnoByLu(int lu);

    @Query("SELECT a FROM Alumno a WHERE a.genero = :genero")
    public List<AlumnoDTO> getAlumnoByGenero(String genero);

    @Query("SELECT a FROM Alumno a " +
            "JOIN AlumnoCarrera ac ON a.dni = ac.alumno.dni " +
            "JOIN Carrera c ON ac.carrera.id = c.id " +
            "WHERE c.id = :id AND a.ciudadResidencia = :ciudad")
    public List<AlumnoDTO> getAlumnoByCarrera(int id, String ciudad);
}

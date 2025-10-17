package repository;

import dto.AlumnoDTO;
import model.AlumnoCarrera;
import model.IdAlumnoCarrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoCarreraRepository extends JpaRepository<AlumnoCarrera, IdAlumnoCarrera> {
    @Query("SELECT new dto.AlumnoDTO(a.dni, a.nombre, a.apellido, a.edad, a.genero, a.ciudadResidencia, a.lu) " +
            "FROM AlumnoCarrera ac JOIN ac.alumno a " +
            "WHERE ac.carrera.id = :idCarrera AND ac.graduado = 0 " +
            "ORDER BY ac.inscripcion ASC")
    List<AlumnoDTO> getInscriptos(int idCarrera);

    @Query("SELECT new dto.AlumnoDTO(a.dni, a.nombre, a.apellido, a.edad, a.genero, a.ciudadResidencia, a.lu) " +
            "FROM AlumnoCarrera ac JOIN ac.alumno a " +
            "WHERE ac.carrera.id = :idCarrera AND ac.graduado != 0 " +
            "ORDER BY ac.inscripcion ASC")
    List<AlumnoDTO> getGraduados(int idCarrera);
}

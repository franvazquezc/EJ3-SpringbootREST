package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class AlumnoCarrera {
    @EmbeddedId
    private IdAlumnoCarrera id;
    @Column(nullable = false)
    private int graduado;
    @Column(nullable = false)
    private int inscripcion;
    @Column(nullable = false)
    private int antiguedad;
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name="id")
    private Carrera carrera;
    @ManyToOne
    @MapsId("dni")
    @JoinColumn(name="dni")
    private Alumno alumno;

    public AlumnoCarrera(Alumno a, Carrera c, int graduado, int inscripcion, int antiguedad) {
        this.alumno = a;
        this.carrera = c;
        this.graduado = graduado;
        this.inscripcion = inscripcion;
        this.antiguedad = antiguedad;
        int idCarrera = carrera.getId();
        int idAlumno = alumno.getDni();
        this.id = new IdAlumnoCarrera(idAlumno, idCarrera);
    }

    public AlumnoCarrera() {}
}

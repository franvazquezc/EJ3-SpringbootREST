package com.tudai.arquitecturasweb.service;

import com.tudai.arquitecturasweb.dto.IdAlumnoCarreraDTO;
import com.tudai.arquitecturasweb.dto.AlumnoDTO;
import lombok.RequiredArgsConstructor;
import com.tudai.arquitecturasweb.model.Alumno;
import com.tudai.arquitecturasweb.model.AlumnoCarrera;
import com.tudai.arquitecturasweb.model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tudai.arquitecturasweb.repository.AlumnoCarreraRepository;
import com.tudai.arquitecturasweb.repository.AlumnoRepository;
import com.tudai.arquitecturasweb.repository.CarreraRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;

    public List<Alumno> getAll(){
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos;
    }

    public Alumno getById(int id){
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(()-> new RuntimeException(
                "Alumno no encontrado"
        ));
        return alumno;
    }

    public Alumno save(Alumno alumno){
        alumnoRepository.save(alumno);
        return alumno;
    }

    public void update(Alumno alumno, int dni){
        Alumno a = alumnoRepository.findById(dni).orElseThrow(()-> new RuntimeException(
                "Alumno no encontrado"
        ));
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setEdad(alumno.getEdad());
        a.setGenero(alumno.getGenero());
        a.setCiudadResidencia(alumno.getCiudadResidencia());
        a.setLu(alumno.getLu());

        alumnoRepository.save(a);
    }

    public void delete(int id){
        alumnoRepository.deleteById(id);
    }

    public List<AlumnoDTO> getAlumnoByCarreraAndCiudad(int idCarrera, String ciudad){
        List<AlumnoDTO> alumnos = alumnoRepository.getAlumnoByCarreraAndCiudad(idCarrera, ciudad);
        if(alumnos.isEmpty()) throw new RuntimeException("No se encontraron alumnos");
        return alumnos;
    }

    public AlumnoDTO getAlumnoByLu(int lu){
        AlumnoDTO a = alumnoRepository.getAlumnoByLu(lu);
        if(a == null) throw new RuntimeException("El alumno no existe");
        return a;
    }

    public List<AlumnoDTO> getAlumnoByGenero(String genero){
        List<AlumnoDTO> alumnos = alumnoRepository.getAlumnoByGenero(genero);
        if(alumnos.isEmpty()) throw new RuntimeException("No se encontraron alumnos");
        return alumnos;
    }

    public List<AlumnoDTO> getAlumnoByCarrera(int id, String ciudad){
        List<AlumnoDTO> alumnos = alumnoRepository.getAlumnoByCarrera(id, ciudad);
        if(alumnos.isEmpty()) throw new RuntimeException("No se encontraron alumnos");
        return alumnos;
    }

    public void matricularAlumnoACarrera(IdAlumnoCarreraDTO acDto){
        Alumno a = this.alumnoRepository.findById(acDto.getDniAlumno()).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        Carrera c = this.carreraRepository.findById(acDto.getIdCarrera()).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        LocalDate hoy = LocalDate.now();

        AlumnoCarrera ac = new AlumnoCarrera(a, c, 0, hoy.getYear(), 0);
        this.alumnoCarreraRepository.save(ac);
    }
}
package service;

import dto.AlumnoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.Alumno;
import model.AlumnoCarrera;
import model.Carrera;
import model.IdAlumnoCarrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlumnoCarreraRepository;
import repository.AlumnoRepository;
import repository.CarreraRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {

    @Autowired
    private final AlumnoRepository alumnoRepository;
    @Autowired
    private final CarreraRepository carreraRepository;

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

        Alumno a = new Alumno(
                alumno.getDni(),
                alumno.getLu(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEdad(),
                alumno.getGenero(),
                alumno.getCiudadResidencia()
        );

        alumnoRepository.save(a);

        return a;
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

    //Consultar con los pibes
//    public void matricularAlumnoACarrera(int dni, int idCarrera, int inscripcion, int graduado, int antiguedad){
//        Alumno a = alumnoRepository.findById(dni).orElseThrow(()-> new RuntimeException());
//        Carrera c = carreraRepository.findById(idCarrera).orElseThrow(()-> new RuntimeException());
//        IdAlumnoCarrera IdAC = new IdAlumnoCarrera(a.getDni(), c.getId());
//        AlumnoCarrera ac = new AlumnoCarrera(IdAC, a, c, graduado, inscripcion, antiguedad);
//        AlumnoCarreraRepository.save(ac);
//    }
}

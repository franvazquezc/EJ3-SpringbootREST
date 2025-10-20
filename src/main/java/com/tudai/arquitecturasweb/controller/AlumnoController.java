package com.tudai.arquitecturasweb.controller;

import com.tudai.arquitecturasweb.dto.AlumnoDTO;
import com.tudai.arquitecturasweb.dto.CarreraDTO;
import com.tudai.arquitecturasweb.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.tudai.arquitecturasweb.service.AlumnoService;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    private final AlumnoService alumnoService;

    public AlumnoController(@Qualifier("AlumnoService") AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/alumnos")
    public Iterable<Alumno> getAlumnos(){
        return alumnoService.getAll();
    }

    @GetMapping("/alumno/{id}")
    public Alumno getAlumno(@PathVariable int id){
        return alumnoService.getById(id);
    }

    @DeleteMapping("/alumno/{id}")
    public void deleteAlumno(@PathVariable int id){
        alumnoService.delete(id);
    }
    //Tiene que dejar de ser void?
    @PostMapping("/alumno")
    public void createAlumno(@RequestBody Alumno alumno){
        alumnoService.save(alumno);
    }

    @PostMapping("/alumno/{id}")
    public void updateAlumno(@RequestBody Alumno alumno, @PathVariable int id){
        alumnoService.update(alumno, id);
    }

    @GetMapping("/alumnos/{idCarrera}/{ciudad}")
    public List<AlumnoDTO> getAlumnoByCarreraAndCiudad(@PathVariable int idCarrera, @PathVariable String ciudad){
        return alumnoService.getAlumnoByCarreraAndCiudad(idCarrera, ciudad);
    }

    @GetMapping("/alumno/lu/{lu}")
    public AlumnoDTO getAlumnoByLu(@PathVariable int lu){
        return alumnoService.getAlumnoByLu(lu);
    }

    @GetMapping("/alumnos/genero/{genero}")
    public List<AlumnoDTO> getAlumnoByGenero(@PathVariable String genero){
        return alumnoService.getAlumnoByGenero(genero);
    }

    @GetMapping("/alumnos/carrera")
    public List<AlumnoDTO> getAlumnoByCarrera(@RequestParam int id, @RequestParam String ciudad){
        return alumnoService.getAlumnoByCarrera(id, ciudad);
    }

    @PostMapping("/alumno/matricularAlumno")
    public void matricularAlumnoACarrera(@RequestBody AlumnoDTO aDto, @RequestBody CarreraDTO cDto){
        alumnoService.matricularAlumnoACarrera(aDto, cDto);
    }
}

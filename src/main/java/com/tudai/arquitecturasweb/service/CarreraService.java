package service;

import dto.ReporteCarreraDTO;
import model.Alumno;
import model.Carrera;
import repository.AlumnoCarreraRepository;
import repository.CarreraRepository;
import dto.CarreraDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;

    public List<Carrera> getAll() {
        List<Carrera> carreras = this.carreraRepository.findAll();
        return carreras;
    }

    public Carrera getById(int id) {
        return this.carreraRepository.findById(id).orElseThrow(()-> new RuntimeException(
                "Carrera no encontrada"
        ));
    }

    public Carrera save(Carrera c) {
        Carrera registro = this.getById(c.getId());
        if(registro != null) {
            throw new RuntimeException("Ya existe un registro con id " + c.getId());
        }
        this.carreraRepository.save(c);
        return c;
    }

    public void delete(int id) {
        Carrera registro = this.getById(id);
        if(registro == null) {
            throw new RuntimeException("No existe un registro con id " + id);
        }
        this.carreraRepository.deleteById(id);
    }

    public void update(int id, Carrera nueva) {
        Carrera c = this.carreraRepository.findById(id).orElseThrow(()-> new RuntimeException(
                "Carrera no encontrada"
        ));
        c.setNombre(nueva.getNombre());
        c.setDuracion(nueva.getDuracion());
        this.carreraRepository.save(c);
    }

    public List<CarreraDTO> getCarrerasOrderByCantAlumnos() {
        return carreraRepository.getCarrerasOrderByCantAlumnos();
    }

    public List<ReporteCarreraDTO> getReporte() {
        List<CarreraDTO> carreras = carreraRepository.getAllOrderByNombre();
        List<ReporteCarreraDTO> reporte = new ArrayList<>();

        for (CarreraDTO c : carreras) {
            ReporteCarreraDTO reporteCarrera = new ReporteCarreraDTO(
                    c.getNombre(),
                    alumnoCarreraRepository.getInscriptos(c.getId()),
                    alumnoCarreraRepository.getGraduados(c.getId())
            );
            reporte.add(reporteCarrera);
        }
        return reporte;
    }
}

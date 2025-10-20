package com.tudai.arquitecturasweb.service;

import com.tudai.arquitecturasweb.dto.ReporteCarreraDTO;
import com.tudai.arquitecturasweb.model.Carrera;
import com.tudai.arquitecturasweb.repository.AlumnoCarreraRepository;
import com.tudai.arquitecturasweb.repository.CarreraRepository;
import com.tudai.arquitecturasweb.dto.CarreraDTO;

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
        this.carreraRepository.save(c);
        return c;
    }

    public void delete(int id) {
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

package service;

import dto.ReporteCarreraDTO;
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

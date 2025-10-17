package service;

import dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlumnoCarreraRepository;

import java.util.List;

@Service
public class AlumnoCarreraService {
    @Autowired
    private AlumnoCarreraRepository repository;

    public List<AlumnoDTO> getInscriptos(int idCarrera) {
        return repository.getInscriptos(idCarrera);
    }

    public List<AlumnoDTO> getGraduados(int idCarrera) {
        return repository.getGraduados(idCarrera);
    }
}

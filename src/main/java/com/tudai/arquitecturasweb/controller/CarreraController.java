package controller;

import dto.CarreraDTO;
import model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import service.CarreraService;

import java.util.List;

@RestController
public class CarreraController {

    @Qualifier("CarreraRepositoryImp")
    @Autowired
    private CarreraService carreraService;

    public CarreraController(@Qualifier("CarreraService")CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping("/carreras")
    public List<Carrera> getCarreras() {
        return carreraService.getAll();
    }

    @GetMapping("/carrera/{id}")
    public Carrera getCarrera(@PathVariable("id") int id) {
        return carreraService.getById(id);
    }

    @DeleteMapping("/carrera/{id}")
    public void deleteCarrera(@PathVariable("id") int id) {
        carreraService.delete(id);
    }

    @PostMapping("/carrera")
    public void createCarrera(@RequestBody Carrera carrera){
        carreraService.save(carrera);
    }

    @PostMapping("/carrera/{id}")
    public void updateCarrera(@RequestBody Carrera nueva, @PathVariable("id") int id){
        carreraService.update(id, nueva);
    }

    @GetMapping("/carrera/OrderByAlumnos")
    public Iterable<CarreraDTO> getCarrerasOrderByCantAlumnos(){
        return carreraService.getCarrerasOrderByCantAlumnos();
    }

    /*
    @GetMapping("/carrera/OrderByNombre")
    public Iterable<Carrera> getCarreraOrderByNombre(){
        return carreraService.getCarrerasOrderByNombre();
    }
    */
}

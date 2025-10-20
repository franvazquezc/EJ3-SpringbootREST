package utils;

import model.Alumno;
import model.AlumnoCarrera;
import model.Carrera;
import model.IdAlumnoCarrera;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlumnoCarreraRepository;
import service.AlumnoService;
import service.CarreraService;

import java.io.FileReader;
import java.io.IOException;

@Service
public class LoadCSV {
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CarreraService carreraService;
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;

    private final String fileCarrera = "src/main/java/utils/CSV/Carrera.csv";
    private final String fileEstudianteCarrera = "src/main/java/utils/CSV/estudianteCarrera.csv";
    private final String fileEstudiantes = "src/main/java/utils/CSV/estudiantes.csv";

    public LoadCSV(){}

    public void LoadCarrera() throws IOException {
        CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileCarrera));
        for(CSVRecord row: csvParser) {
            int id = Integer.parseInt(row.get("id_carrera"));
            String nombre = row.get("carrera");
            int duracion = Integer.parseInt(row.get("duracion"));
            Carrera c = new Carrera(id, nombre, duracion);
            this.carreraService.save(c);
        }
    }

    public void LoadAlumnos() throws IOException {
        CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudiantes));
        for(CSVRecord row: csvParser) {
            int dni = Integer.parseInt(row.get("DNI"));
            int lu = Integer.parseInt(row.get("LU"));
            String nombre = row.get("nombre");
            String apellido = row.get("apellido");
            int edad = Integer.parseInt(row.get("edad"));
            String genero = row.get("genero");
            String ciudad = row.get("ciudad");

            Alumno a = new Alumno(dni, lu, nombre, apellido, edad, genero, ciudad);
            this.alumnoService.save(a);
        }
    }

    public void LoadAlumnoCarrera() throws IOException {
        CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudianteCarrera));
        for(CSVRecord row: csvParser) {
            int id_alumno = Integer.parseInt(row.get("id_estudiante"));
            int id_carrera = Integer.parseInt(row.get("id_carrera"));
            int graduacion = Integer.parseInt(row.get("graduacion"));
            int inscripcion = Integer.parseInt(row.get("inscripcion"));
            int antiguedad = Integer.parseInt(row.get("antiguedad"));

            Alumno a =  this.alumnoService.getById(id_alumno);
            Carrera c = this.carreraService.getById(id_carrera);
            AlumnoCarrera ac = new AlumnoCarrera(a, c, graduacion, inscripcion, antiguedad);

            this.alumnoCarreraRepository.save(ac);
        }
    }
}

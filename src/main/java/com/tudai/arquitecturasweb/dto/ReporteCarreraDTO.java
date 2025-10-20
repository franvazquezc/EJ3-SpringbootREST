package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ReporteCarreraDTO {
    private String nombreCarrera;
    private List<AlumnoDTO> inscriptos;
    private List<AlumnoDTO> graduados;

    public ReporteCarreraDTO(String nombreCarrera, List<AlumnoDTO> inscriptos, List<AlumnoDTO> graduados) {
        this.nombreCarrera = nombreCarrera;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }
}

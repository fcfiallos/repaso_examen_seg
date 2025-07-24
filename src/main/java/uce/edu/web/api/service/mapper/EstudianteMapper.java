package uce.edu.web.api.service.mapper;

import java.util.List;

import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

public class EstudianteMapper {
    public static EstudianteTo toTO(Estudiante estudiante) {
        EstudianteTo estudianteTo = new EstudianteTo();
        estudianteTo.setNombre(estudiante.getNombre());
        estudianteTo.setApellido(estudiante.getApellido());
        estudianteTo.setCedula(estudiante.getCedula());
        estudianteTo.setId(estudiante.getId());
        return estudianteTo;
    }

    public static List<EstudianteTo> toTOList(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(EstudianteMapper::toTO)
                .toList();
    }
    public static Estudiante toEntity(EstudianteTo estudianteTo){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteTo.getNombre());
        estudiante.setApellido(estudianteTo.getApellido());
        estudiante.setCedula(estudianteTo.getCedula());
        return estudiante;
    }
}

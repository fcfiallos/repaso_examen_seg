package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {
    public List<Estudiante> buscarTodos();
    public void guardar(EstudianteTo estudiante);
    public Estudiante buscarPorCedula(String cedula);
}

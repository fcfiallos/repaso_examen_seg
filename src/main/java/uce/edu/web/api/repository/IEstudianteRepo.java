package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.model.Estudiante;

public interface IEstudianteRepo {
    public List<Estudiante> seleccionarTodos();

    public void insertar(Estudiante estudiante);

    public Estudiante seleccionarPorCedula(String cedula);
}

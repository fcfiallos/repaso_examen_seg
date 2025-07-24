package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepo;
import uce.edu.web.api.repository.model.Estudiante;
import uce.edu.web.api.service.mapper.EstudianteMapper;
import uce.edu.web.api.service.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {
    @Inject
    private IEstudianteRepo estudianteRepo;

    @Override
    public List<Estudiante> buscarTodos() {
        return this.estudianteRepo.seleccionarTodos();
    }

    @Override
    public void guardar(EstudianteTo estudiante) {
        this.estudianteRepo.insertar(EstudianteMapper.toEntity(estudiante));
    }

    @Override
    public Estudiante buscarPorCedula(String cedula) {
        return this.estudianteRepo.seleccionarPorCedula(cedula);
    }

}

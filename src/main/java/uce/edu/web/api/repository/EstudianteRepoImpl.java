package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estudiante> seleccionarTodos() {
        return entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    }

    @Override
    public void insertar(Estudiante estudiante) {
        entityManager.persist(estudiante);
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
       return entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula", Estudiante.class)
                .setParameter("cedula", cedula)
                .getSingleResult();
    }

}

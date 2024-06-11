package abm;

import jakarta.persistence.*;

public abstract class GestorGenérico<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public void guardar(T entidad) {
        entityManager.persist(entidad);
    }

    public T obtenerPorId(Class<T> clase, Long id) {
        return entityManager.find(clase, id);
    }

    public void actualizar(T entidad) {
        entityManager.merge(entidad);
    }

    public void eliminar(T entidad) {
        entityManager.remove(entidad);
    }
}


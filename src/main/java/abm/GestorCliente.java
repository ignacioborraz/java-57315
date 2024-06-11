package abm;

import jakarta.persistence.*;

public class GestorCliente extends GestorGenérico<Cliente> {

    public Cliente obtenerPorNombre(String nombre) {
        TypedQuery<Cliente> consulta = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :nombre", Cliente.class);
        consulta.setParameter("nombre", nombre);
        return consulta.getSingleResult();
    }
}


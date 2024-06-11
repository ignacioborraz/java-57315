package abm;

public class GestorProducto extends GestorGenérico<Producto> {

    public void agregarAlCarrito(Cliente cliente, Producto producto) {
        cliente.getCarrito().add(producto);
        entityManager.merge(cliente);
    }

    public void quitarDelCarrito(Cliente cliente, Producto producto) {
        cliente.getCarrito().remove(producto);
        entityManager.merge(cliente);
    }
}


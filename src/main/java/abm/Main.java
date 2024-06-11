package abm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private GestorCliente gestorCliente;
    private GestorProducto gestorProducto;

    public Main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("commercePU");
        entityManager = entityManagerFactory.createEntityManager();
        gestorCliente = new GestorCliente();
        gestorCliente.entityManager = entityManager;
        gestorProducto = new GestorProducto();
        gestorProducto.entityManager = entityManager;
    }

    public static void main(String[] args) {
        Main test = new Main();

        try {
            Cliente cliente1 = new Cliente();
            cliente1.setNombre("Juan");
            cliente1.setApellido("Pérez");
            cliente1.setDni("12345678");
            cliente1.setEdad(30);

            Cliente cliente2 = new Cliente();
            cliente2.setNombre("Matias");
            cliente2.setApellido("Pérez");
            cliente2.setDni("87654321");
            cliente2.setEdad(40);

            Producto producto1 = new Producto();
            producto1.setNombre("Laptop 1");
            producto1.setPrecio(1000);
            producto1.setStock(10);
            Producto producto2 = new Producto();
            producto2.setNombre("Laptop 2");
            producto2.setPrecio(2000);
            producto2.setStock(10);
            Producto producto3 = new Producto();
            producto3.setNombre("Laptop 3");
            producto3.setPrecio(3000);
            producto3.setStock(10);
            Producto producto4 = new Producto();
            producto4.setNombre("Laptop 4");
            producto4.setPrecio(4000);
            producto4.setStock(10);

            test.entityManager.getTransaction().begin();
            test.entityManager.persist(cliente1);
            test.entityManager.persist(cliente2);
            test.entityManager.persist(producto1);
            test.entityManager.persist(producto2);
            test.entityManager.persist(producto3);
            test.entityManager.persist(producto4);
            test.entityManager.getTransaction().commit();

            test.entityManager.getTransaction().begin();
            test.gestorProducto.agregarAlCarrito(cliente1, producto1);
            test.gestorProducto.agregarAlCarrito(cliente1, producto2);
            test.gestorProducto.agregarAlCarrito(cliente1, producto3);
            test.gestorProducto.agregarAlCarrito(cliente1, producto4);
            test.gestorProducto.agregarAlCarrito(cliente2, producto4);
            test.entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

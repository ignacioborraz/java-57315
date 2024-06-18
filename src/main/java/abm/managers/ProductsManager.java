package abm.managers;

import abm.entities.Product;
import jakarta.persistence.*;

import java.util.List;

public class ProductsManager {
    public void create(String name, int stock, double price) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = BaseProvider.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Product product = new Product(name,stock,price);
            manager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            BaseProvider.closeEntity(manager);
        }
    }
    public List<Product> readAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            List<Product> products = entityManager.createQuery("FROM Product", Product.class).getResultList();
            return products;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }
    public Product readOne(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            Product product = entityManager.find(Product.class, id);
            return product;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }

}

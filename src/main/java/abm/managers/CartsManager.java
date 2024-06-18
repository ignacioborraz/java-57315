package abm.managers;

import abm.entities.Product;
import abm.entities.Client;
import abm.entities.Cart;

import jakarta.persistence.*;

import java.util.List;

public class CartsManager {

    public void addToCart(int amount, Product product, Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Cart cart = new Cart();
            cart.setAmount(amount);
            cart.setPrice(product.getPrice());
            cart.setClient(client);
            cart.setProduct(product);
            entityManager.persist(cart);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }
    public void removeToCart(Product product, Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Cart invoiceDetail = entityManager
                    .createQuery("SELECT id FROM Cart id WHERE id.product = :product AND id.client = :client", Cart.class)
                    .setParameter("product", product)
                    .setParameter("client", client)
                    .getSingleResult();
            entityManager.remove(invoiceDetail);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }
    public List<Cart> readByClient(Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            List<Cart> invoicesDetails = entityManager
                    .createQuery("SELECT id FROM Cart id WHERE id.client = :client", Cart.class)
                    .setParameter("client", client).getResultList();
            return invoicesDetails;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }

}

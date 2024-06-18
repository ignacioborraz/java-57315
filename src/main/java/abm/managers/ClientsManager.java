package abm.managers;

import abm.entities.Client;
import jakarta.persistence.*;

import java.util.List;

public class ClientsManager {
    public void create(String name) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = BaseProvider.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Client client = new Client(name);
            manager.persist(client);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            BaseProvider.closeEntity(manager);
        }
    }
    public List<Client> readAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            List<Client> clients = entityManager.createQuery("FROM Client", Client.class).getResultList();
            return clients;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }
    public Client readOne(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = BaseProvider.get();
            Client client = entityManager.find(Client.class, id);
            return client;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            BaseProvider.closeEntity(entityManager);
        }
    }

}

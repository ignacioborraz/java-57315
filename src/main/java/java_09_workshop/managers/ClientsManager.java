package java_09_workshop.managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java_09_workshop.entities.Client;

import java.util.List;

public class ClientsManager {
    public void create(String name, Integer docnumber) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Client client = new Client();
            client.setName(name);
            client.setDocnumber(docnumber);
            manager.persist(client);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
    }
    public Client readOne(Integer id) {
        EntityManager manager = null;
        Client client = null;
        try {
            manager = Manager.get();
            client = manager.find(Client.class, id);
            //condicionar QUE PASA SI NO EXISTE
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
            return client;
        }
    }
    //public List<Client> readAll() {
        //puede incluir un argumento para filtro!!!
    //}
}

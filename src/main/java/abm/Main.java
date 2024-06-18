package abm;

import abm.entities.Client;
import abm.entities.Product;
import abm.managers.CartsManager;
import abm.managers.ClientsManager;
import abm.managers.InvoicesManager;
import abm.managers.ProductsManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductsManager product = new ProductsManager();
        //product.create("campera roja",1000,10);
        //product.create("campera azul",1000,10);
        //product.create("campera verde",1000,20);
        //product.create("campera naranja",1000,20);
        //product.create("campera blanca",1000,15);
        //product.create("campera negra",1000,15);
        Product oneProduct = product.readOne(1);
        System.out.println(oneProduct);
        List<Product> products = product.readAll();
        System.out.println(products);
        ClientsManager client = new ClientsManager();
        //client.create("igna");
        //client.create("fran");
        //client.create("felipe");
        List<Client> all = client.readAll();
        System.out.println(all);
        Client oneClient = client.readOne(1);
        System.out.println(oneClient);
        CartsManager cart = new CartsManager();
        //cart.addToCart(1,oneProduct,oneClient);
        //cart.addToCart(1,product.readOne(2),oneClient);
        //cart.addToCart(1,product.readOne(3),oneClient);
        //cart.addToCart(1,product.readOne(4),client.readOne(2));
        //cart.removeToCart(oneProduct,oneClient);
        System.out.println(cart.readByClient(oneClient));
        InvoicesManager invoice = new InvoicesManager();
        invoice.doInvoice(oneClient);
    }
}

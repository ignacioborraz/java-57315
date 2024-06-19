package java_09_workshop;

import java_09_workshop.managers.CartsManager;
import java_09_workshop.managers.ClientsManager;
import java_09_workshop.managers.ProductsManager;

public class Main {
    public static void main(String[] args) {
        ProductsManager product = new ProductsManager();
        //product.create("zapatillas azules", 100, 50.25);
        //product.create("zapatillas rojas", 105, 54.75);
        //product.create("zapatillas negras", 98, 60);
        //product.create("remeras azules", 500, 49.25);
        //product.create("remeras rojas", 600, 58);
        //product.create("remeras negras", 687, 52.5);
        System.out.println(product.readOne(1));
        ClientsManager client = new ClientsManager();
        //client.create("igna",35249);
        //client.create("fran",38357);
        System.out.println(client.readOne(1));
        CartsManager cart = new CartsManager();
        //cart.addToCart(1,product.readOne(1),client.readOne(1));
        //cart.addToCart(1,product.readOne(6),client.readOne(1));
        //cart.addToCart(1,product.readOne(6),client.readOne(2));
        System.out.println(cart.readByClient(client.readOne(1)));
        System.out.println(cart.readByClient(client.readOne(2)));
    }
}

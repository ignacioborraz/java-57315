package abm.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;
    private double price;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart() {}

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(price, cart.price) == 0 && Objects.equals(id, cart.id) && Objects.equals(amount, cart.amount) && Objects.equals(client, cart.client) && Objects.equals(product, cart.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, price, client, product);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", client=" + client +
                ", product=" + product +
                '}';
    }
}

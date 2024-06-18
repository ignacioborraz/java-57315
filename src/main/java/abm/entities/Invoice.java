package abm.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Invoice() {
        this.createdAt = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(amount, invoice.amount) == 0 && Objects.equals(id, invoice.id) && Objects.equals(createdAt, invoice.createdAt) && Objects.equals(client, invoice.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, amount, client);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                ", client=" + client +
                '}';
    }
}

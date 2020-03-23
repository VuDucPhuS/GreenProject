package E_Commerce.E_Commerce.Production;
import javax.persistence.Id;

import E_Commerce.E_Commerce.Sales.Store;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id",nullable = false)
    private Store stores;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Stock() {
    }

    public Stock(Long quantity, Store stores, Product product) {
        this.quantity = quantity;
        this.stores = stores;
        this.product = product;
    }
}

package E_Commerce.E_Commerce.Sales;

import E_Commerce.E_Commerce.Production.Product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "orderItems")
public class OrderItems{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long quantity;

    private Long list_price;

    private Long discount;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",nullable = false,foreignKey =  @ForeignKey(name = "fk_order"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Product",nullable = false)
    private Product products;

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

    public Long getList_price() {
        return list_price;
    }

    public void setList_price(Long list_price) {
        this.list_price = list_price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public OrderItems(Order order) {
        this.order = order;
    }

    public OrderItems(Long quantity,Long list_price, Long discount, Order order, Product products) {
        this.quantity = quantity;
        this.list_price = list_price;
        this.discount = discount;
        this.order = order;
        this.products = products;
    }

    public OrderItems() {
    }
}
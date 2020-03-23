package E_Commerce.E_Commerce.Production;


import E_Commerce.E_Commerce.Sales.OrderItems;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "This is mandatory")
    private String product_name;

    private int model_year;

    private Long list_price;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id",nullable = false)
    protected Brand brand;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id", nullable = false,foreignKey = @ForeignKey(name = "color"))
    protected Color color;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "products",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderItems> orderItems;

    public Product(String product_name,int model_year,Long list_price, Brand brand, Color color) {
        this.product_name = product_name;
        this.model_year = model_year;
        this.list_price = list_price;
        this.brand = brand;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public Long getList_price() {
        return list_price;
    }

    public void setList_price(Long list_price) {
        this.list_price = list_price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Product() {
    }
}

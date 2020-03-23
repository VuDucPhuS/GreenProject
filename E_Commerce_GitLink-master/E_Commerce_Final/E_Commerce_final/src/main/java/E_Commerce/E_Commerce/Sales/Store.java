package E_Commerce.E_Commerce.Sales;

import E_Commerce.E_Commerce.Production.Stock;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "This is mandatory")
    private String store_name;

    @NotBlank(message = "This is mandatory")
    private String store_phone;

    @NotBlank(message = "This is mandatory")
    private String store_email;

    @NotBlank(message = "This is mandatory")
    private String store_street;

    @NotBlank(message = "This is mandatory")
    private String store_city;

    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Staff> staffs;

    @OneToMany(mappedBy = "Store",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "stores", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Stock> stocks;

    public Store(String store_name,String store_phone,String store_email,String store_street,String store_city) {
        this.store_name = store_name;
        this.store_phone = store_phone;
        this.store_email = store_email;
        this.store_street = store_street;
        this.store_city = store_city;
    }

    public Store() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(String store_phone) {
        this.store_phone = store_phone;
    }

    public String getStore_email() {
        return store_email;
    }

    public void setStore_email(String store_email) {
        this.store_email = store_email;
    }

    public String getStore_street() {
        return store_street;
    }

    public void setStore_street(String store_street) {
        this.store_street = store_street;
    }

    public String getStore_city() {
        return store_city;
    }

    public void setStore_city(String store_city) {
        this.store_city = store_city;
    }
}

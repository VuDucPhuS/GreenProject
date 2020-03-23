package E_Commerce.E_Commerce.Sales;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="Client_id", nullable = false)
    private Client client;
    private Date date;
    @NotBlank(message = "This is mandatory")
    private String status;
    private Date required_date;
    private Date shipped_date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="Store_id", nullable = false)
    private Store Store;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderItems> orderItems;

    public Order(Client client,Date date,String status,Date required_date,Date shipped_date, Store store, Staff staff) {

        this.client = client;
        this.date = date;
        this.status = status;
        this.required_date = required_date;
        this.shipped_date = shipped_date;
        this.Store = store;
        this.staff = staff;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequired_date() {
        return required_date;
    }

    public void setRequired_date(Date required_date) {
        this.required_date = required_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public E_Commerce.E_Commerce.Sales.Store getStore() {
        return Store;
    }

    public void setStore(E_Commerce.E_Commerce.Sales.Store store) {
        Store = store;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Set<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }


}

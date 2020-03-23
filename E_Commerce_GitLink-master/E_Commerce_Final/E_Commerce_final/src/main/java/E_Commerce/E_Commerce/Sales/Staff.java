package E_Commerce.E_Commerce.Sales;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "This is mandatory")
    private String staff_name;

    @NotBlank(message = "This is mandatory")
    private String staff_email;
    @NotBlank(message = "This is mandatory")
    private String staff_phone;
    @NotBlank(message = "This is mandatory")
    private String staff_active;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="Store_id",nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Manager_id", nullable = false)
    private Staff staff;

    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Staff(String staff_name,String staff_email,String staff_phone, String staff_active, Store store, Staff staff) {

        this.staff_name = staff_name;
        this.staff_email = staff_email;
        this.staff_phone = staff_phone;
        this.staff_active = staff_active;
        this.store = store;
        this.staff = staff;
    }

    public Staff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_active() {
        return staff_active;
    }

    public void setStaff_active(String staff_active) {
        this.staff_active = staff_active;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}

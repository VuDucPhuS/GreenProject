package E_Commerce.E_Commerce.Production;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "This is mandatory")
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> products;

    public Brand( String name) {
        this.name = name;
    }
    public Brand(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

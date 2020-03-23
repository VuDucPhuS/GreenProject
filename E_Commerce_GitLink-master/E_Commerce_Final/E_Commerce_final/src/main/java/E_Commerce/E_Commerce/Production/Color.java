package E_Commerce.E_Commerce.Production;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long color_id;

    @NotBlank(message = "This is mandatory")
    private String color_name;

   @OneToMany(mappedBy = "color", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> products;

    public Color(String color_name) {
        this.color_name = color_name;
    }

    public Color() {}

    public Long getColor_id() {
        return color_id;
    }

    public void setColor_id(Long color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
}

package E_Commerce.E_Commerce.Controller;

import E_Commerce.E_Commerce.Production.Brand;
import E_Commerce.E_Commerce.Production.Color;
import E_Commerce.E_Commerce.Production.Product;
import E_Commerce.E_Commerce.repository.BrandRepository;
import E_Commerce.E_Commerce.repository.ColorRepository;
import E_Commerce.E_Commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
public class ProductController {
       private final ProductRepository productRepository;
       private final BrandRepository brandRepository;
       private final ColorRepository colorRepository;

       public String replace(String a){
        String b = a;
            for(int i=0;i<b.length();i++)
            {
                if(b.charAt(i)== '+')
                {
                    b = b.substring(0,i) +" "+ b.substring(i+1,b.length());
                }
            }
            return b;
        }
       @Autowired
       public ProductController(ProductRepository productRepository, BrandRepository brandRepository, ColorRepository colorRepository)
       {
           this.productRepository = productRepository;
           this.brandRepository = brandRepository;
           this.colorRepository = colorRepository;
       }

       @PostMapping("/product/add")
       public String addProduct(@RequestBody String product, BindingResult result, Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
           if(result.hasErrors())
           {
               return "add-entity/add-product";
           }

           String product_name = "";
           Long price= Long.valueOf(0);
           int model_year = 0;
           Brand br = null;
           Color cl = null;
           Optional<Color> demo = colorRepository.findById(Long.valueOf(109));
           if(demo.isPresent())
           {
               cl = demo.get();
           }
           String[] arr = product.split("&");
           for(int i=1;i<=5;i++)
           {
               String val = arr[i].split("=")[1];
               if(i==1)
               {
                   product_name = replace(val);
               }
               if(i==2) {
                   model_year = Integer.valueOf(val);
               }
                if(i==3)
                {
                    price = Long.valueOf(val);
                }
                if(i==4)
                {
                    Long x = Long.valueOf(val);
                    Optional<Brand> brs = brandRepository.findById(x);
                    if(brs.isPresent()) {
                        br = brs.get();
                    }
                }
               if(i==5)
               {
                   Long y = Long.valueOf(val);
                   Optional<Color> cls = colorRepository.findById(y);
                   if(cls.isPresent())
                   {
                       cl = cls.get();
                   }
               }
           }
           productRepository.save(new Product(product_name,model_year,price,br,cl));
           resp.sendRedirect("/product");
           return "index";
       }

       @GetMapping("/product/add")
       public String add_Product()
       {
           return "add-entity/add-product";
       }

       @GetMapping("/product")
       public String index(Model model){
            model.addAttribute("products",productRepository.findAll());
            return "index";
       }
}

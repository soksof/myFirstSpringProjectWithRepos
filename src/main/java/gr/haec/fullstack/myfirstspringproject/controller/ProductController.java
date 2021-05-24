package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.model.Product;
import gr.haec.fullstack.myfirstspringproject.model.ProductType;
import gr.haec.fullstack.myfirstspringproject.service.ProductService;
import gr.haec.fullstack.myfirstspringproject.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    ProductService productService;
    ProductTypeService productTypeService;

    public ProductController(ProductService productService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @RequestMapping(value = "/product/new", method = RequestMethod.GET)
    public String newProduct(ModelMap model){
        Product newProduct = new Product();
        List<ProductType> types = productTypeService.findAll();
        model.addAttribute("product", newProduct);
        model.addAttribute("types", types);
        return "product/new";
    }

    @RequestMapping(value = "/product/new", method = RequestMethod.POST)
    public String storeNewProduct(@Valid Product product, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println(error.getDefaultMessage());
            }
            List<ProductType> types = productTypeService.findAll();
            model.addAttribute("types", types);
            return "product/new";
        }
        System.out.println("Storing product: "+product);
        productService.save(product);
        return "index";
    }

    @GetMapping("/view/product/{pid}")
    public String viewProduct(@PathVariable("pid") int productId, ModelMap model){
        Product product = productService.getById(productId);
        if(product == null)
            return "error/404";
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/view/product/type/{type}")
    public String viewAllLaptops(@PathVariable("type") String productTypeString, ModelMap model){
        ProductType productType = productTypeService.getProductByType((productTypeString));
        if(productType==null){
            return "error/404";
        }
        List<Product> productsByType = productService.getByType(productType);
        model.addAttribute("products", productsByType);
        return "index";
    }
}

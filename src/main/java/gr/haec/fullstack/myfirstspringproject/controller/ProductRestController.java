package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.exceptions.MyException;
import gr.haec.fullstack.myfirstspringproject.model.Product;
import gr.haec.fullstack.myfirstspringproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {
    ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value="/products/{pid}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable("pid") Integer productId){
        Product product = productService.getById(productId);
        if(product==null){
            throw(new MyException("No data found for product with this id!!!!!!!!!!!!!"));
            //return ResponseEntity.notFound().build();
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(product);
        //return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @ExceptionHandler({MyException.class, NullPointerException.class})
    public ResponseEntity handleMyException(MyException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Method returned an error");
    }
}

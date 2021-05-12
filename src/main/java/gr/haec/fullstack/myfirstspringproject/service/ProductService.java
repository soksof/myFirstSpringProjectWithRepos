package gr.haec.fullstack.myfirstspringproject.service;

import gr.haec.fullstack.myfirstspringproject.model.*;
import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product getById(int id);
    public Product save(Product product);
    public List<Product> getByType(ProductType type);
}

package gr.haec.fullstack.myfirstspringproject.service;

import gr.haec.fullstack.myfirstspringproject.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    public List<ProductType> findAll();
    public ProductType getProductByType(String type);
}

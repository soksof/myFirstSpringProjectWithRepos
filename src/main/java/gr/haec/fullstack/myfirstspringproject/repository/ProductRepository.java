package gr.haec.fullstack.myfirstspringproject.repository;

import gr.haec.fullstack.myfirstspringproject.model.Product;
import gr.haec.fullstack.myfirstspringproject.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameAndPrice(String name, double price);
    List<Product> findByPriceBetween(double a, double b);
    List<Product> findByType(ProductType type);
}

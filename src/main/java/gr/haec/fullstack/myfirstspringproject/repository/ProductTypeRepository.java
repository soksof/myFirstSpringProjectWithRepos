package gr.haec.fullstack.myfirstspringproject.repository;

import gr.haec.fullstack.myfirstspringproject.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    ProductType getProductTypeByType(String type);
}

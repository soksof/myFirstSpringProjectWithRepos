package gr.haec.fullstack.myfirstspringproject;

import gr.haec.fullstack.myfirstspringproject.model.Product;
import gr.haec.fullstack.myfirstspringproject.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager em;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByName() {
        em.persist(new Product(0, "Foo", "Foo", 0));

        List<Product> products = productRepository.findByName("Foo");
        assertEquals("Foo", products.get(0).getName());
        assertEquals(1, products.size());
    }
}

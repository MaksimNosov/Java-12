import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product product1 = new Book(11, "Book 1", 100, "Author 1");
    Product product2 = new Smartphone(22, "Smartphone 1", 200, "Manufacture 1");
    Product product3 = new Book(33, "Book 2", 300, "Author 2");
    Product product4 = new Smartphone(44, "Smartphone 2", 400, "Manufacture 2");


    ProductRepository repo = new ProductRepository();

    @BeforeEach
    public void setUp() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
    }

    @Test
    public void saveProduct() {

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {

        repo.removeById(product3.getId());

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

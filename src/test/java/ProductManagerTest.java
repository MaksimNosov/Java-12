import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductManagerTest {
    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(11, "Book 1", 100, "Author 1");
    Product product2 = new Smartphone(22, "Smartphone 1", 200, "Manufacture 1");
    Product product3 = new Book(33, "Book 2", 300, "Author 2");
    Product product4 = new Smartphone(44, "Smartphone 2", 400, "Manufacture 2");

    @Test
    public void shouldSearchByNameBook() {      //находится ровно один товар по названию книги
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Book 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBook2() {     //находится 0 товаров по названию книги, т.е. ни один товар не подходит
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Book 3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBook3() {     //находится несколько товаров по названию книги
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelManufacture() {      //находится ровно один товар по производителю
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Manufacture 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelManufacture2() {     //находится 0 товаров по производителю, т.е. ни один товар не подходит
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Manufacture 5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelManufacture3() {     //находится несколько товаров по производителю
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product2, product4};
        Product[] actual = manager.searchBy("Manufacture");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelAuthor() {      //находится ровно один товар по автору
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Author 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelAuthor2() {     //находится 0 товаров по автору, т.е. ни один товар не подходит
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Author 5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelAuthor3() {     //находится несколько товаров по автору
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("Author");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelNameSmartphone() {      //находится ровно один товар по названию смартфона
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Smartphone 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelNameSmartphone2() {     //находится 0 товаров по названию смартфона, т.е. ни один товар не подходит
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Smartphone 5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModelNameSmartphone3() {     //находится несколько товаров по названию смартфона
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product2, product4};
        Product[] actual = manager.searchBy("Smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }


}

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

//    public void add(Product product) {
//        repo.save(product);
//    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {

                result[result.length - 1] = product;




                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}

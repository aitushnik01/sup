import java.util.ArrayList;
import java.util.List;


class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        products.clear();
    }

    public List<Product> getProducts() {
        return products;
    }
}

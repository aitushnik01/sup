import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Demo class for customer interface
public class OnlineShopDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Initialize a map of items and their prices
        Map<String, Double> itemPrices = new HashMap<>();
        itemPrices.put("Laptop", 999.99);
        itemPrices.put("Smartphone", 499.99);
        itemPrices.put("Headphones", 79.99);

        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] Show Items for Sale");
            System.out.println("[2] Add Product to Cart");
            System.out.println("[3] View Cart");
            System.out.println("[4] Checkout");
            System.out.println("[5] Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Items for Sale:");
                    for (Map.Entry<String, Double> entry : itemPrices.entrySet()) {
                        System.out.println(entry.getKey() + " - $" + entry.getValue());
                    }
                    break;
                case 2:
                    System.out.println("Choose a product to add to the cart:");
                    for (Map.Entry<String, Double> entry : itemPrices.entrySet()) {
                        System.out.println(entry.getKey() + " - $" + entry.getValue());
                    }
                    scanner.nextLine();
                    String selectedItem = scanner.nextLine();
                    if (itemPrices.containsKey(selectedItem)) {
                        System.out.println("Enter quantity:");
                        int quantity = scanner.nextInt();
                        Product selectedProduct = new Product(selectedItem, itemPrices.get(selectedItem), quantity);
                        cart.addProduct(selectedProduct);
                        System.out.println(quantity + " " + selectedItem + " added to the cart.");
                    } else {
                        System.out.println("Invalid product choice.");
                    }
                    break;
                case 3:
                    List<Product> productsInCart = cart.getProducts();
                    System.out.println("Cart Contents:");
                    for (Product p : productsInCart) {
                        System.out.println("Name: " + p.getName() + ", Price: $" + p.getPrice() + ", Quantity: " + p.getQuantity());
                    }
                    System.out.println("Total: $" + cart.calculateTotal());
                    break;
                case 4:
                    System.out.println("Select Payment Strategy:");
                    System.out.println("[1] Credit Card");
                    System.out.println("[2] PayPal");
                    System.out.println("[3] Show Singleton Message");
                    int paymentChoice = scanner.nextInt();
                    PaymentStrategy paymentStrategy = null;

                    switch (paymentChoice) {
                        case 1:
                            System.out.println("Enter Credit Card Number:");
                            String cardNumber = scanner.next();
                            paymentStrategy = new CreditCardPayment(cardNumber);
                            break;
                        case 2:
                            System.out.println("Enter PayPal Email:");
                            String email = scanner.next();
                            paymentStrategy = new PayPalPayment(email);
                            break;
                        case 3:
                            paymentProcessor.showMessage();
                            break;
                        default:
                            System.out.println("Invalid Payment Strategy.");
                            continue;
                    }

                    paymentProcessor.setPaymentStrategy(paymentStrategy);
                    double totalAmount = cart.calculateTotal();
                    paymentProcessor.checkout(totalAmount);
                    cart.clearCart();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}


import java.util.Scanner;

// PaymentStrategy interface


// Concrete payment strategy classes


class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

// PaymentProcessor class with Singleton pattern

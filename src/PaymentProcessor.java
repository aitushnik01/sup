//Payment initialization and other staff, double-checking
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private static PaymentProcessor instance;

    private PaymentProcessor() {
        // Private constructor,
    }
//double-checking
    public static PaymentProcessor getInstance() {
        if (instance == null) {
            synchronized (PaymentProcessor.class) {
                if (instance == null) {
                    instance = new PaymentProcessor();
                }
            }
        }
        return instance;
    }


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double totalAmount) {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(totalAmount);
        } else {
            System.out.println("Please set a payment strategy before checkout.");
        }
    }
    public void showMessage() {
        System.out.println("This is a message from PaymentProcessor Singleton.");
    }
}
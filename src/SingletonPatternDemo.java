public class SingletonPatternDemo {
    public static void main(String[] args) {
        // Get an instance of the PaymentProcessor Singleton
        PaymentProcessor paymentProcessor1 = PaymentProcessor.getInstance();
        PaymentProcessor paymentProcessor2 = PaymentProcessor.getInstance();

        // Print hash codes of both instances
        System.out.println("Hash Code of paymentProcessor1: " + paymentProcessor1.hashCode());
        System.out.println("Hash Code of paymentProcessor2: " + paymentProcessor2.hashCode());

        // Demonstrate Singleton with multiple threads
        Runnable task = () -> {
            PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
            System.out.println("Thread " + Thread.currentThread().getId() + ": Hash Code of paymentProcessor: " + paymentProcessor.hashCode());
        };

        // Create multiple threads to request instances simultaneously, double-checking
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(task);
            Thread thread2 = new Thread(task);
            Thread thread3 = new Thread(task);
            Thread thread4 = new Thread(task);
            Thread thread5 = new Thread(task);
            Thread thread6 = new Thread(task);
            Thread thread7 = new Thread(task);
            Thread thread8 = new Thread(task);
            Thread thread9 = new Thread(task);
            thread.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
            thread9.start();
            thread9.start();
        }
    }
}

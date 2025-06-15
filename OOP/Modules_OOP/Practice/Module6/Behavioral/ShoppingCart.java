package Practice.Module6.Behavioral;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Method to set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        // Delegate the payment call to the strategy object
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

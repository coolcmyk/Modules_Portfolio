package Practice.Module6.Behavioral;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234-5678-9012-3456");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(150);

        System.out.println("--- Changing payment method ---");

        // Pay using PayPal
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com");
        cart.setPaymentStrategy(paypal);
        cart.checkout(200);
    }
}
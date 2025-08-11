package src;

import src.Strategy.CreditCardPayment;
import src.Strategy.GooglePayPayment;
import src.Strategy.PayPalPayment;
import src.Strategy.PaymentStrategy;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount : $");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Select payment method:");
        System.out.println("1. Paypal");
        System.out.println("2. GooglePay");
        System.out.println("3. Credit Card");

        System.out.println("Your choice: ");
        int choice=sc.nextInt();
        sc.nextLine();

        PaymentStrategy strategy = null;


        // We can use Factory Design Pattern for creating strategies.
        switch (choice) {
            case 1:
                System.out.print("Enter your PayPal email: ");
                String email = sc.nextLine();
                strategy = new PayPalPayment(email);
                break;
            case 2:
                System.out.print("Enter your pin: ");
                String pin = sc.nextLine();
                strategy = new GooglePayPayment(pin);
                break;
            case 3:
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter your card number: ");
                String card = sc.nextLine();
                System.out.print("Enter your CVV: ");
                String cvv = sc.nextLine();
                System.out.print("Enter your expiry date (MM/YY): ");
                String expiry = sc.nextLine();
                strategy = new CreditCardPayment(name, card, cvv, expiry);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        PaymentProcessor processor = new PaymentProcessor(strategy);
        processor.processPayment(amount);
        sc.close();

    }
}

import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get exchange rates from a reliable source (e.g., an API)
        double usdToInrRate = 80.05;  // Replace with actual rate from API
        double eurToInrRate = 85.62;  // Replace with actual rate from API

        System.out.println("Welcome to the Currency Converter!");

        // Get user input
        System.out.print("Enter the amount to convert: ");
        double amount = sc.nextDouble();

        System.out.print("Enter the currency code (USD, EUR, or INR): ");
        String fromCurrency = sc.next().toUpperCase();

        System.out.print("Enter the target currency code (USD, EUR, or INR): ");
        String toCurrency = sc.next().toUpperCase();

        // Perform conversion based on currency codes
        double convertedAmount = 0.0;
        switch (fromCurrency) {
            case "USD":
                if (toCurrency.equals("INR")) {
                    convertedAmount = amount * usdToInrRate;
                } else if (toCurrency.equals("EUR")) {
                    // Convert USD to INR first, then INR to EUR
                    convertedAmount = amount * usdToInrRate / eurToInrRate;
                }
                break;
            case "EUR":
                if (toCurrency.equals("INR")) {
                    convertedAmount = amount * eurToInrRate;
                } else if (toCurrency.equals("USD")) {
                    convertedAmount = amount / eurToInrRate * usdToInrRate;
                }
                break;
            case "INR":
                if (toCurrency.equals("USD")) {
                    convertedAmount = amount / usdToInrRate;
                } else if (toCurrency.equals("EUR")) {
                    convertedAmount = amount / usdToInrRate * eurToInrRate;
                }
                break;
            default:
                System.out.println("Invalid currency code.");
                return;
        }

        // Display the converted amount
        if (convertedAmount > 0) {
            System.out.printf("%.2f %s is equal to %.2f %s.", amount, fromCurrency, convertedAmount, toCurrency);
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> currencySymbols = new HashMap<>();
        currencySymbols.put("USD", "$");
        currencySymbols.put("EUR", "€");
        currencySymbols.put("INR", "₹");

        System.out.println("--- Currency Converter ---");
        System.out.print("Enter base currency (USD, EUR, INR): ");
        String base = scanner.nextLine().toUpperCase();
        System.out.print("Enter target currency (USD, EUR, INR): ");
        String target = scanner.nextLine().toUpperCase();
        System.out.print("Enter amount to convert: ");
        double amount = 0;
        while (true) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) break;
                else System.out.print("Amount must be positive. Enter again: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
        double rate = getExchangeRate(base, target);
        if (rate != -1) {
            double converted = amount * rate;
            String symbol = currencySymbols.getOrDefault(target, target); 
            System.out.printf("%.2f %s = %s%.2f%n", amount, base, symbol, converted);
        } else {
            System.out.println("Conversion not available for these currencies.");
        }

        scanner.close();
    }
    public static double getExchangeRate(String base, String target) {
        if (base.equals("USD") && target.equals("EUR")) return 0.915;
        if (base.equals("EUR") && target.equals("USD")) return 1.093;
        if (base.equals("USD") && target.equals("INR")) return 83.5;
        if (base.equals("INR") && target.equals("USD")) return 0.012;
        if (base.equals("EUR") && target.equals("INR")) return 91.2;
        if (base.equals("INR") && target.equals("EUR")) return 0.011;
        if (base.equals(target)) return 1;
        return -1; 
    }
}

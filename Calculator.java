import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN;
        }
        return a / b;
    }

    public static double modulus(double a, double b) {
        return a % b;
    }

    public static double power(Scanner scanner, double base) {
        return Math.pow(base, 2);
    }

    public static double squareRoot(double a) {
        if (a < 0) {
            System.out.println("Error: Cannot take square root of negative number.");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }

    // Reusable input method with label
    public static double getNumberInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("\n=== Java Console Calculator ===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. Power (^)");
            System.out.println("7. Square Root (√)");
            System.out.print("Enter your choice (1–7): ");
            int choice = scanner.nextInt();

            double num1 = 0, num2 = 0, result = 0;

            // Take two numbers only for operations 1–5
            if (choice >= 1 && choice <= 5) {
                num1 = getNumberInput(scanner, "Enter the First Number: ");
                num2 = getNumberInput(scanner, "Enter the Second Number: ");
            }

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
                case 5:
                    result = modulus(num1, num2);
                    break;
                case 6:
                    num1 = getNumberInput(scanner, "Enter the Number: ");
                    result = power(scanner, num1);
                    break;
                case 7:
                    num1 = getNumberInput(scanner, "Enter the Number: ");
                    result = squareRoot(num1);
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 7.");
                    continue;
            }

            System.out.println("Result: " + result);
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            scanner.nextLine();
            String again = scanner.nextLine();
            continueCalculation = again.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }
}

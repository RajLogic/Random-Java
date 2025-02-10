import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {  // Infinite loop to allow multiple calculations
            try {
                // Prompt user for input
                System.out.print("\nEnter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter an operator (+, -, *, /, %, ^): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                // Perform calculation and display result
                double result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the buffer
            }

            // Ask if user wants to continue
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    // Separate method for calculations
    public static double calculate(double num1, double num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Error! Division by zero.");
                    yield Double.NaN;
                }
                yield num1 / num2;
            }
            case '%' -> num1 % num2;
            case '^' -> Math.pow(num1, num2);
            default -> {
                System.out.println("Invalid operator!");
                yield Double.NaN;
            }
        };
    }
}

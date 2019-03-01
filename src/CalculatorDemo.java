/* CalculatorDemo.java
 * Author:  William Craycroft
 * Module:  4
 * Project: Homework 4, Project #2
 * Problem Statement: This class demonstrates the functionality of the UnknownOperatorException and
 *      DivideByZeroException classes by simulating a basic calculator application.
 *
 * Algorithm / Plan:
 *      1. Instantiate result (double) to 0.0.
 *      2. Prompt user for an operator and a number
 *      3. If user enters 'P', terminate program.
 *      4. If user enters 'R', reset to 0.0.
 *      5. If user enters an invalid operator, throw/catch UnknownOperatorException. Return to step 2.
 *      6. If user enters an invalid number, throw/catch NumberFormatException. Return to step 2.
 *      7. If operator is divisor and number is 0, throw/catch DivideByZeroException. Return to step 2
 *      8. Else, parse operator and perform calculation on result.
 *      9. Repeat steps 1-8 until program is terminated (step 3).
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorDemo {

    public static void main(String[] args) {


        // Declarations
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat oneDP = new DecimalFormat("0.0");

        double result = 0.0;      // accumulator holding current result of all previous calculations
        String operator;          // operator input by the user
        double number;            // operand input by the user


        // Power on message
        System.out.println("Calculator is now on.\nThe result is currently " + oneDP.format(result));

        // Start of user input loop
        // Will not break until program is terminated by user.
        while (true) {

            // Prompt user
            System.out.println("\nEnter an operator (+, -, *, or /) and a number, \"R\" to reset, or \"P\" to power off:");
            try {
                // Get operator and operand
                operator = keyboard.next();

                // Handle reset and power inputs
                if (operator.equalsIgnoreCase("R")) {
                    result = 0.0;
                    System.out.println("The calculator has been reset to 0.");
                }
                else if (operator.equalsIgnoreCase("P")) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                // If operator is not "P" or "R"...
                else {

                    // If there is no double next in Scanner
                    if (!keyboard.hasNextDouble()) {
                        throw new NumberFormatException(String.format("%s is not a valid number. The result is still %s",
                                keyboard.next(), oneDP.format(result)));
                    }
                    number = keyboard.nextDouble();

                    // Validate operator and perform calculations for other inputs
                    switch (operator) {
                        // Addition
                        case "+":
                            System.out.printf("The result of %s + %s is %s%n", oneDP.format(result), oneDP.format(number),
                                    oneDP.format(result + number));
                            result += number;
                            break;
                        // Subtraction
                        case "-":
                            System.out.printf("The result of %s - %s is %s%n", oneDP.format(result), oneDP.format(number),
                                    oneDP.format(result - number));
                            result -= number;
                            break;
                        // Multiplication
                        case "*":
                            System.out.printf("The result of %s * %s is %s%n", oneDP.format(result), oneDP.format(number),
                                    oneDP.format(result * number));
                            result *= number;
                            break;
                        // Division
                        case "/":
                            // Check for division by 0, if true, throw DivideByZeroException exception
                            if (number == 0) {
                                throw new DivideByZeroException("You cannot divide by 0. The results is still "
                                        + oneDP.format(result));
                            }
                            // If not dividing by zero...
                            System.out.printf("The result of %s / %s is %s%n", oneDP.format(result), oneDP.format(number),
                                    oneDP.format(result / number));
                            result /= number;
                            break;
                        // If operator is not recognized, throw UnknownOperatorException
                        default:
                            throw new UnknownOperatorException(
                                    String.format("\"%s\" is not a valid operator. The result is still %s",
                                            operator, oneDP.format(result)));

                    }    // end of operator switch statement

                }   // end of "P" or "R" operator else statement

            }
            // Catch throwable exceptions, print error message.
            catch (NumberFormatException | DivideByZeroException | UnknownOperatorException e) {
                System.err.println(e.getMessage());
            }
            finally {
                // Clear newline character before new prompt
                keyboard.nextLine();
            }

        } // end of user input loop

    }  // end of main
}

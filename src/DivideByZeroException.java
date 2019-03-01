/* DivideByZeroException.java
 * Author:  William Craycroft
 * Module:  4
 * Project: Homework 4, Project #2
 * Description: This exception class will return an error message warning that the user has attempted to divide by zero.
 *
 *       Constructors:
 *           Default constructor - displays a default divide by zero error message.
 *           Parameterized constructor - takes in a error message to be displayed (String).
 */

public class DivideByZeroException extends Exception {

    // Default constructor - default error message for dividing by zero.
    public DivideByZeroException() {
        super("You cannot divide by zero.");
    }

    // Parameterized constructor - takes in error message to be displayed as String parameter
    public DivideByZeroException(String message) {
        super(message);
    }
}

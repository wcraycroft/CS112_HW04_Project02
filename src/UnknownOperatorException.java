/* UnknownOperatorException.java
 * Author:  William Craycroft
 * Module:  4
 * Project: Homework 4, Project #2
 * Description: This exception class will return an error message warning that the user has entered an invalid operator.
 *
 *       Constructors:
 *           Default constructor - displays a default invalid operator error message.
 *           Parameterized constructor - takes in a error message to be displayed (String).
 */

public class UnknownOperatorException extends Exception {

    // Default constructor - default error message for invalid operator input.
    public UnknownOperatorException() {
        super("You have entered an invalid operator.");
    }

    // Parameterized constructor - takes in error message to be displayed as String parameter
    public UnknownOperatorException(String message) {
        super(message);
    }
}

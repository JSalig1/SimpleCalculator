package app;
import java.io.*;

/**
 * @author Jeremy Salig
 * @version 1.0
 */

public class SimpleCalculator {
  public static void main(String[] args) {
    String userInput1 = getInput("Enter a numeric value: ");
    double num1 = setNum(userInput1);
    String userInput2 = getInput("Enter a numeric value: ");
    double num2 = setNum(userInput2);
    String operation = getInput("Select an operation. Valid entries: ADD, SUBTRACT, MULTIPLY, DIVIDE: ");
    Operation value = setOpertion(operation);

    double result = 0;

    switch (value) {
      case ADD:
        result = addValues(num1, num2);
        break;
      case SUBTRACT:
        result = subtractValues(num1, num2);
        break;
      case MULTIPLY:
        result = multiplyValues(num1, num2);
        break;
      case DIVIDE:
        result = divideValues(num1, num2);
        break;
      case INVALID:
        return;
    }

    System.out.println("The answer is: " + result);
  }

  private static Operation setOpertion (String operation) throws IllegalArgumentException {
    try {
      Operation value = Operation.valueOf(operation);
      return value;
    } catch (IllegalArgumentException error) {
      System.out.println("That was an invalid operation");
      return Operation.INVALID;
    }
  }

  private static double setNum (String userInput) throws NumberFormatException {
    try {
      double num = Double.parseDouble(userInput);
      return num;
    } catch (NumberFormatException error) {
      System.out.println("That was not a valid number");
      System.exit(0);
      return 0;
    }
  }

  private static double addValues (double num1, double num2) {
    double result = num1 + num2;
    return result;
  }

  private static double subtractValues (double num1, double num2) {
    double result = num1 - num2;
    return result;
  }

  private static double multiplyValues (double num1, double num2) {
    double result = num1 * num2;
    return result;
  }

  private static double divideValues (double num1, double num2) {
    double result = num1 / num2;
    return result;
  }

  private static String getInput(String prompt) {
    BufferedReader stdin = new BufferedReader(
      new InputStreamReader(System.in));

    System.out.print(prompt);
    System.out.flush();

    try {
      return stdin.readLine();
    } catch (Exception error) {
      return "Error: " + error.getMessage();
    }
  }
}

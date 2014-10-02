import java.io.*;

public class SimpleCalculator {
  public static void main(String[] args) {
    String s1 = getInput("Enter a numeric value: ");
    String s2 = getInput("Enter a numeric value: ");
    String operation = getInput("Select an operation. Valid entries: ADD, SUBTRACT, MULTIPLY, DIVIDE ");
    Operation value = setOpertion(operation);

    double result = 0;

    switch (value) {
      case ADD:
        result = addValues(s1, s2);
        break;
      case SUBTRACT:
        result = subtractValues(s1, s2);
        break;
      case MULTIPLY:
        result = multiplyValues(s1, s2);
        break;
      case DIVIDE:
        result = divideValues(s1, s2);
        break;
      case INVALID:
        System.out.println("That was an invalid operation");
        return;
    }

    System.out.println("The answer is: " + result);
  }
  
  private static Operation setOpertion (String operation) throws NumberFormatException {
    try {
      Operation value = Operation.valueOf(operation);
      return value;
    } catch (IllegalArgumentException e) {
      return Operation.INVALID;
    }
  }

  private static double addValues (String s1, String s2) throws NumberFormatException {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    double result = d1 + d2;
    return result;
  }

  private static double subtractValues (String s1, String s2) throws NumberFormatException {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    double result = d1 - d2;
    return result;
  }

  private static double multiplyValues (String s1, String s2) throws NumberFormatException {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    double result = d1 * d2;
    return result;
  }

  private static double divideValues (String s1, String s2) throws NumberFormatException {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    double result = d1 / d2;
    return result;
  }

  private static String getInput(String prompt) {
    BufferedReader stdin = new BufferedReader(
      new InputStreamReader(System.in));

    System.out.print(prompt);
    System.out.flush();

    try {
      return stdin.readLine();
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }
}

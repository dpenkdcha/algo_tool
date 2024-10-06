package week6;

import java.util.Arrays;
import java.util.Scanner;

public class PlacingParentheses {

  // Function to perform basic operations
  public static long calc(long a, long b, char op) {
    switch (op) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      default:
        throw new IllegalArgumentException("Unknown operator: " + op);
    }
  }

  // Function to calculate the minimum and maximum values between i and j
  public static long[] MinAndMax(long[][] M, long[][] m, int i, int j, char[] operators) {
    long minValue = Long.MAX_VALUE;
    long maxValue = Long.MIN_VALUE;

    for (int k = i; k < j; k++) {
      long a = calc(M[i][k], M[k + 1][j], operators[k]);
      long b = calc(M[i][k], m[k + 1][j], operators[k]);
      long c = calc(m[i][k], M[k + 1][j], operators[k]);
      long d = calc(m[i][k], m[k + 1][j], operators[k]);

      minValue = Math.min(minValue, Math.min(a, Math.min(b, Math.min(c, d))));
      maxValue = Math.max(maxValue, Math.max(a, Math.max(b, Math.max(c, d))));
    }

    return new long[] { minValue, maxValue };
  }

  // Function to compute the maximum value of the expression
  public static long getMaximumValue(int[] operands, char[] operators) {
    int n = operands.length;
    long[][] m = new long[n][n];
    long[][] M = new long[n][n];

    // Initialize the diagonal with operand values
    for (int i = 0; i < n; i++) {
      m[i][i] = operands[i];
      M[i][i] = operands[i];
    }

    // Fill the tables m and M
    for (int s = 1; s < n; s++) {
      for (int i = 0; i < n - s; i++) {
        int j = i + s;
        long[] result = MinAndMax(M, m, i, j, operators);
        m[i][j] = result[0]; // min value
        M[i][j] = result[1]; // max value
      }
    }


    //  for (int[] row : m) {
    //   System.out.println(Arrays.toString(row));
    // }

    // for (int[] row : M) {
    //   System.out.println(Arrays.toString(row));
    // }

    // Return the maximum value from M[0][n-1]
    return M[0][n - 1];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String expression = sc.nextLine();

    // Split the expression into operands and operators
    StringBuilder operandsBuilder = new StringBuilder();
    StringBuilder operatorsBuilder = new StringBuilder();

    for (char c : expression.toCharArray()) {
      if (c == '+' || c == '-' || c == '*') {
        operatorsBuilder.append(c);
      } else {
        operandsBuilder.append(c);
      }
    }

    // Convert strings into arrays of operands and operators
    char[] operators = operatorsBuilder.toString().toCharArray();
    int[] operands = new int[operandsBuilder.length()];
    for (int i = 0; i < operandsBuilder.length(); i++) {
      operands[i] = Character.getNumericValue(operandsBuilder.charAt(i));
    }

    // Compute and print the maximum value of the expression
    System.out.println(getMaximumValue(operands, operators));
    sc.close();
  }
}

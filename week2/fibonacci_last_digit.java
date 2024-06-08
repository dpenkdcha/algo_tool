

import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of a Large Fibonacci Number
public class fibonacci_last_digit {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    BigInteger value;
    int[] lastDigit = new int[60];

    if (n == 0) {
      lastDigit[0] = 0;
    } else if (n == 1) {
      lastDigit[1] = 1;
    } else {
      BigInteger n_0 = BigInteger.ZERO;
      BigInteger n_1 = BigInteger.ONE;
      for (int i = 2; i < 60; i++) {
        value = n_0.add(n_1);
        n_0 = n_1;
        n_1 = value;
        lastDigit[i] = value.mod(BigInteger.TEN).intValue();
      }
    }

    System.out.println(lastDigit[n % 60]);
  }
}

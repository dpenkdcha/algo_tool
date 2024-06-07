package week2;

import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers Again
public class fibonacci_partial_sum {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
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
        lastDigit[i] = value.mod(BigInteger.valueOf(10)).intValue();
      }
    }

    System.out.println(lastDigit[(m+1) % 60] - lastDigit[(n+2) % 6]);
  }
}

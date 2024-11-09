package module1.week2;

import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of the Sum of Squares of Fibonacci Numbers
public class fibonacci_sum_of_squares {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    BigInteger value;
    int[] lastDigit = new int[60];

    lastDigit[0] = 0;
    lastDigit[1] = 1;
    BigInteger n_0 = BigInteger.ZERO;
    BigInteger n_1 = BigInteger.ONE;
    for (int i = 2; i < 60; i++) {
      value = n_0.add(n_1);
      n_0 = n_1;
      n_1 = value;
      lastDigit[i] = value.mod(BigInteger.valueOf(10)).intValue();
      // System.out.println("n " + i + " value " + value + " last " + lastDigit[i]);
    }

    // System.out.println("n " + n % 60 + " n+1 " + (n + 1) % 60);
    System.out.println((lastDigit[(int) (n % 60)] * lastDigit[(int) ((n + 1) % 60)])%10);
    scanner.close();
  }
}

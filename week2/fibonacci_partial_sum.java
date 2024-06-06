package week2;

import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers Again
public class fibonacci_partial_sum {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    BigInteger value = null;
//    BigInteger sum = null;
    BigInteger valueS = null;

    if (m == 0) {
      valueS = BigInteger.ONE;
    } else if (m == 1) {
      valueS = BigInteger.ONE;
    }

    if (n == 0) {
      value = BigInteger.ZERO;
    } else if (n == 1) {
      value = BigInteger.ONE;
    } else {
      BigInteger n_0 = BigInteger.ZERO;
      BigInteger n_1 = BigInteger.ONE;
//      sum = BigInteger.ONE;
      for (int i = 2; i <= n + 2; i++) {
        value = n_0.add(n_1);
//        sum = sum.add(value);
        n_0 = n_1;
        n_1 = value;
        if (i == m + 1) {
          valueS = value;
        }
        // System.out.println("n " + i + " value " + value + " valueS " + valueS );
      }
      value = value.subtract(valueS);
    }
    System.out.println(value.toString().substring(value.toString().length() - 1));

  }
}

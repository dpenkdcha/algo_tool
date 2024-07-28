package week2;


import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers
public class fibonacci_sum_old {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    BigInteger value = null;
//    BigInteger sum = null;

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
//        System.out.println("n " + i + " value " + value + " sum " + sum);

      }
      value = value.subtract(BigInteger.ONE);
    }
    System.out.println(value.toString().substring(value.toString().length() - 1));
    scanner.close();
  }
}

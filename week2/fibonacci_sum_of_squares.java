package week2;

import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci_sum_of_squares {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    BigInteger value = null;
    BigInteger value_1 = null;
//    BigInteger sum = null;

    if (n == 0) {
      value = BigInteger.ZERO;
    } else if (n == 1) {
      value = BigInteger.ONE;
    } else {
      BigInteger n_0 = BigInteger.ZERO;
      BigInteger n_1 = BigInteger.ONE;
//      sum = BigInteger.ONE;
      for (int i = 2; i <= n + 1; i++) {
        value = n_0.add(n_1);
//        sum = sum.add(value);
        n_0 = n_1;
        value_1 = n_1;
        n_1 = value;
//        System.out.println("n " + i + " value " + value + " sum " + " value_1 " + value_1);
      }
//      value = value.subtract(BigInteger.ONE);
    }

    BigInteger squareSumLastDigit = (value.multiply(value_1)).remainder(BigInteger.TEN);
//    int lastDigit = Integer.parseInt(squareSum.toString().substring(value.toString().length() - 1));
//    System.out.println("value " + value.multiply(BigInteger.valueOf(n)) + " lastDigit " + squareSumLastDigit);
    System.out.println(squareSumLastDigit);

  }
}

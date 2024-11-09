package module1.week2;

import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    BigInteger value = null;

    if (n == 0) {
      value = BigInteger.ZERO;
    } else if (n == 1) {
      value = BigInteger.ONE;
    } else {
      BigInteger n_0 = BigInteger.ZERO;
      BigInteger n_1 = BigInteger.ONE;
      for (int i = 2; i <= n; i++) {
        value = n_0.add(n_1);
        n_0 = n_1;
        n_1 = value;
      }
    }

    System.out.println(value);
    scanner.close();
  }
}

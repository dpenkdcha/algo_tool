package week2;

import java.math.BigInteger;
import java.util.Scanner;

public class huge_fibonacci {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    int m = scanner.nextInt();
    BigInteger value = null;
    BigInteger modVal = null;

    if (n == 1) {
      modVal = BigInteger.ONE;
    } else {
      BigInteger n_0 = BigInteger.ZERO;
      BigInteger n_1 = BigInteger.ONE;
      for (int i = 2; i <= n%m; i++) {
        value = n_0.add(n_1);
        n_0 = n_1;
        n_1 = value;
        System.out.println("n " + i + " value " + value);
        if (value.mod(BigInteger.valueOf(m)).intValue() > m) {
          modVal = value.mod(BigInteger.valueOf(m));
          break;
        }
      }
    }

    System.out.println(modVal);
  }
}

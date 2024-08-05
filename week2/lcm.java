package week2;

import java.util.Scanner;

public class lcm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    lcm gcd = new lcm();
    long d = gcd.eucld(n, m);
    System.out.println((n * m) / d);
    scanner.close();
  }

  private long eucld(long a, long b) {
    if (b == 0)
      return a;
    else {
      return eucld(b, a % b);
    }
  }
}

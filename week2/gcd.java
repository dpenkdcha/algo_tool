package week2;

import java.util.Scanner;

public class gcd {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    gcd gcd = new gcd();
    long d = gcd.eucld(n, m);
    System.out.println(d);
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

package week2;

import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers
public class fibonacci_sum {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    BigInteger value;
    int[] lastDigit = new int[60];
    long val;

    lastDigit[0]=0;
    lastDigit[1]=1;
    if (n == 0) {
      val = 0;
    } else if (n == 1) {
      val = 1;
    } else {
      BigInteger n_0 = BigInteger.ZERO;
      BigInteger n_1 = BigInteger.ONE;
      for (int i = 2; i < 60; i++) {
        value = n_0.add(n_1);
        n_0 = n_1;
        n_1 = value;
        lastDigit[i] = value.mod(BigInteger.TEN).intValue();
        // System.out.println("n " + i + " value " + value + " last " + lastDigit[i] + " n mod " + (n+2)%60);
      }

      int modN = (int)((n+2)%60);
      val = lastDigit[modN];
      if(val == 0 ) {
        val = 9;
      } else {
        val = val - 1;
      }
    }

    System.out.println(val);
    scanner.close();
  }
}

package module1.week2;

import java.math.BigInteger;
import java.util.Scanner;

// Last Digit of the Sum of Fibonacci Numbers Again
public class fibonacci_partial_sum {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long m = scanner.nextLong();
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
      // System.out.println("i " + i + " value " + value + " last " + lastDigit[i] + " m " + (m+1)%60 + " n " + (n+2)%60);
    }

    int mVal = lastDigit[(int) ((m + 1) % 60)];
    int nVal = lastDigit[(int) ((n + 2) % 60)];

    if (mVal == 0) {
      mVal = 9;
    } else {
      mVal = mVal - 1;
    }

    if (nVal == 0) {
      nVal = 9;
    } else {
      nVal = nVal - 1;
    }

    if(mVal>nVal) {
      nVal = nVal+10;
    }

    // System.out.println("mVal" + mVal + " nval " + nVal);

    System.out.println(Math.abs(mVal - nVal));
    scanner.close();
  }
}

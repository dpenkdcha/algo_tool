package week3;

import java.util.Scanner;

// 3-4: Maximum Advertisement Revenue (Maximum Dot Product)
public class dot_product {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long[] price = new long[n];
    long[] clicks = new long[n];

    for (int i = 0; i < n; i++) {
      price[i] = scanner.nextInt();
    }

    for (int i = 0; i < n; i++) {
      clicks[i] = scanner.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (price[i] > price[j]) {
          long temp = price[j];
          price[j] = price[i];
          price[i] = temp;
        }

        if (clicks[i] > clicks[j]) {
          long temp = clicks[j];
          clicks[j] = clicks[i];
          clicks[i] = temp;
        }
      }
    }

    long revenue = 0;
    for (int i = 0; i < n; i++) {
      revenue = revenue + (price[i] * clicks[i]);
    }

    System.out.println(revenue);
    scanner.close();
  }

}
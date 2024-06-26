package week3;

import java.util.Scanner;

// 3-4: Maximum Advertisement Revenue (Maximum Dot Product)
public class dot_product {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] price = new int[n];
    int[] clicks = new int[n];

    for (int i = 0; i < n; i++) {
      price[i] = scanner.nextInt();
    }

    for (int i = 0; i < n; i++) {
      clicks[i] = scanner.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (price[i] > price[j]) {
          int temp = price[j];
          price[j] = price[i];
          price[i] = temp;
        }

        if (clicks[i] > clicks[j]) {
          int temp = clicks[j];
          clicks[j] = clicks[i];
          clicks[i] = temp;
        }
      }
    }

    int revenue = 0;
    for (int i = 0; i < n; i++) {
      revenue = revenue + (price[i] * clicks[i]);
    }

    System.out.println(revenue);

  }

}
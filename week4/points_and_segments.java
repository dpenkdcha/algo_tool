package week4;

import java.util.Scanner;

// 4-6: Organizing a Lottery
public class points_and_segments {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
    }

    scanner.close();
  }
  
}

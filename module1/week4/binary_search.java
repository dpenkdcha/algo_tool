package module1.week4;

import java.util.Scanner;

// 4-1: Binary Search
public class binary_search {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
    }

    int k = scanner.nextInt();
    for (int i = 0; i < k; i++) {
      int x = binaryserach(A, scanner.nextInt());
      System.out.print(x + " ");
    }

    scanner.close();
  }

  private static int binaryserach(int[] A, int k) {
    int lo = 0;
    int hi = A.length - 1;

    while (hi >= lo) {
      int mid = (lo + hi) / 2;
      if (A[mid] == k)
        return mid;
      else if (A[mid] > k)
        hi = mid - 1;
      else
        lo = mid + 1;
    }
    return -1;
  }
}

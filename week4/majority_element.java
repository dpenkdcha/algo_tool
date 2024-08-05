package week4;

import java.util.Scanner;

// 4-3: Majority Element
public class majority_element {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
    }

    int candidate = findCandidate(A, n);

    if (isMajority(A, n, candidate))
      System.out.println("1");
    else
      System.out.println("0");
    scanner.close();
  }

  private static int findCandidate(int a[], int size) {
    int maj_index = 0, count = 1;
    int i;
    for (i = 1; i < size; i++) {
      if (a[maj_index] == a[i])
        count++;
      else
        count--;
      if (count == 0) {
        maj_index = i;
        count = 1;
      }
    }
    return a[maj_index];
  }

  private static boolean isMajority(int[] a, int length, int candidate) {
    int i, count = 0;
    for (i = 0; i < length; i++) {
      if (a[i] == candidate)
        count++;
    }
    if (count > (length / 2))
      return true;
    else
      return false;

  }
}

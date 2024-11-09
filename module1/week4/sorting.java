package module1.week4;

import java.util.Scanner;

// 4-4: Improving QuickSort
public class sorting {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
    }

    sort(A, 0, n - 1);

    for(int i=0;i<n;i++){
      System.out.print(A[i] + " ");
    }

    scanner.close();
  }

  private static void sort(int[] a, int lo, int hi) {
    if (hi <= lo)
      return;
    int lt = lo, gt = hi;
    int v = a[lo];
    int i = lo;

    while (i <= gt) {
      if (a[i] < v)
        swap(a, lt++, i++);
      else if (a[i] > v)
        swap(a, i, gt--);
      else
        i++;
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
  }

  private static void swap(int[] a, int i, int j) {
    int x = a[i];
    a[i] = a[j];
    a[j] = x;
  }
}

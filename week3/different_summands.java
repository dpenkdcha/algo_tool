package week3;

import java.util.Scanner;

// 3-6: Maximum Number of Prizes (Different Summands)
public class different_summands {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] k = new int[n];

    int count = 1;
    int kIndex = 1;
    while (n > 0) {
      if (((n - count) > k[kIndex - 1]) || ((n - count) == 0)) {
        k[kIndex] = count;
        n = n - count;
        count++;
        kIndex++;
      } else if ((n - count) < 0) {
        int negativeVal = n - count;
        for (int j = 0; j < count; j++) {
          if (k[j] + negativeVal == 0) {
            k[j] = count;
            n = n - count;
            break;
          }
        }
      } else {
        count++;
      }
    }

    System.out.println(kIndex-1);
    for (int i = 1; i < kIndex; i++) {
      System.out.print(k[i] + " ");
    }

  }
}

package week5;

import java.util.Arrays;
import java.util.Scanner;

// 5-4: Longest Common Subsequence of Two Sequence
public class lcs2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = scanner.nextInt();
    }

    int m = scanner.nextInt();
    int[] b = new int[m + 1];
    for (int i = 1; i <= m; i++) {
      b[i] = scanner.nextInt();
    }

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      dp[i][0] = 0;
    }

    for (int j = 1; j <= m; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a[i] == b[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }

    System.out.println(Arrays.toString(b));
    int k = 0;
    for (int[] row : dp) {
      System.out.print(a[k++]);
      System.out.println(Arrays.toString(row));
    }

    System.out.println(dp[n][m]);

    // back track and print common element
    int i = n, j = m;
    String output = "";
    while (i > 0 && j > 0) {
      if (a[i] == b[j]) {
        output = String.join(" ", String.valueOf(a[i]), output);
        if (dp[i][j - 1] > dp[i - 1][j]) {
          j--;
        } else
          i--;
      } else {
        i--;
        j--;
      }
    }

    System.out.println(output);

    scanner.close();

  }

}

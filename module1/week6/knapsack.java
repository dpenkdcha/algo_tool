package module1.week6;

import java.util.Scanner;

// 6-1: Maximum Amount of Gold
public class knapsack {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W = scanner.nextInt();
    int n = scanner.nextInt();
    int[] value = new int[n];
    for (int i = 0; i < n; i++) {
      value[i] = scanner.nextInt();
    }

    int[][] dp = new int[value.length + 1][W + 1];

    for (int i = 1; i <= value.length; i++) {
      for (int j = 1; j <= W; j++) {
        if (j >= value[i - 1]) {
          dp[i][j] = Math.max(dp[i - 1][j - value[i - 1]] + value[i - 1], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // for (int[] row : dp) {
    //   // System.out.print(a[k++]);
    //   System.out.println(Arrays.toString(row));
    // }

    System.out.println(dp[value.length][W]);

    scanner.close();
  }
}

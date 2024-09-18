package week6;

import java.util.Arrays;

/**
 * KnapsackWithoutRepetitions
 */
public class KnapsackWithoutRepetitions {

  public static void main(String[] args) {
    int W = 10;
    int[] value = { 30, 14, 16, 9 };
    int[] weight = { 6, 3, 4, 2 };
    boolean[] marked = new boolean[value.length + 1];
    int[][] dp = new int[value.length + 1][W + 1];

    for (int i = 1; i <= value.length; i++) {
      Arrays.fill(marked, false);
      for (int j = 1; j <= W; j++) {
        if (j >= weight[i - 1] && !marked[i - 1]) {
          if (dp[i][j - weight[i - 1]] + value[i - 1] > dp[i - 1][j]) {
            dp[i][j] = dp[i][j - weight[i - 1]] + value[i - 1];
            marked[i - 1] = true;
          } else {
            dp[i][j] = dp[i - 1][j];
            marked[i - 1] = false;
          }
          // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // System.out.println(Arrays.toString(b));
    int k = 0;
    for (int[] row : dp) {
      // System.out.print(a[k++]);
      System.out.println(Arrays.toString(row));
    }

  }
}
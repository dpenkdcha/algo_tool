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
    int[][] dp = new int[value.length + 1][W + 1];

    for (int i = 1; i <= value.length; i++) {
      for (int j = 1; j <= W; j++) {
        if (j >= weight[i - 1]) {
          dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + value[i - 1], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // System.out.println(Arrays.toString(b));
    int k = 0;
    for (int[] row : dp) {
      // System.out.print(a[k++]);
      System.out.println(Arrays.toString(row));
    }

    // Back track
    int[] backTrack = new int[value.length];
    int p = value.length-1;
    int x = value.length, y = W;
    while (x > 0) {
      while (y > 0) {
        if(dp[x][y] == dp[x-1][y]){
          backTrack[p] = 0;
          x--;
        } else {
          backTrack[p] = 1;
          x--;
          y = y-weight[x];
          System.out.println("Value " + value[x] + " Weight " + weight[x]);
        }
        p--;
      }
    }

    System.out.println(Arrays.toString(backTrack));

  }
}
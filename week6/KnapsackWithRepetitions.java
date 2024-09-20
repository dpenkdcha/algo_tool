package week6;

import java.util.Arrays;

/**
 * KnapsackWithoutRepetitions
 */
public class KnapsackWithRepetitions {

  public static void main(String[] args) {
    int W = 10;
    int[] value = { 30, 14, 16, 9 };
    int[] weight = { 6, 3, 4, 2 };

    // With 1D
    int[] maxValue = new int[W + 1];

    maxValue[0] = 0;
    for (int i = 1; i <= W; i++) {
      maxValue[i] = 0;
      for (int j = 0; j < value.length; j++) {
        if (weight[j] <= i) {
          int val = maxValue[i - weight[j]] + value[j];

          if (val > maxValue[i]) {
            maxValue[i] = val;
          }
        }
      }
    }

    System.out.println(Arrays.toString(maxValue));
    System.out.println();

    // Back track
    int[] backTrack = new int[value.length];
    int x = value.length - 1, y = W;
    while (y > 0 && x >= 0) {
      if (maxValue[y] == maxValue[y - weight[x]] + value[x]) {
        backTrack[x] = backTrack[x] + 1;
        y = y - weight[x];
        System.out.println("Value " + value[x] + " Weight " + weight[x]);
      } else {
        x--;
      }
    }

    System.out.println(Arrays.toString(backTrack));

    // With 2D
    int[][] dp = new int[value.length + 1][W + 1];

    for (int i = 1; i <= value.length; i++) {
      for (int j = 1; j <= W; j++) {
        if (j >= weight[i - 1]) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);
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
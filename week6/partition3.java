package week6;

import java.util.Arrays;
import java.util.Scanner;

// 6-2: Partitioning Souvenirs
public class partition3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int sum = 0;
    int[] value = new int[n];
    for (int i = 0; i < n; i++) {
      int x = scanner.nextInt();
      value[i] = x;
      sum += x;
    }

    if (n < 3) {
      System.out.println(0);
      scanner.close();
      return;
    }

    if (sum % 3 != 0) {
      System.out.println(0);
      scanner.close();
      return;
    }

    int splitLoot = sum / 3;
    int count = 0;
    int[][] dp = new int[n + 1][splitLoot + 1];

    boolean[][] dpBol = new boolean[splitLoot + 1][n + 1];

    for (int i = 0; i <= n; i++)
      dpBol[0][i] = true;

    for (int i = 1; i <= splitLoot; i++)
      dpBol[i][0] = false;

    for (int i = 1; i <= splitLoot; i++) {
      for (int j = 1; j <= n; j++) {
        dpBol[i][j] = dpBol[i][j - 1];
        if (i >= value[j - 1])
          dpBol[i][j] = dpBol[i][j] || dpBol[i - value[j - 1]][j - 1];
      }
    }

    // for (boolean[] row : dpBol) {
    //   // System.out.print(a[k++]);
    //   System.out.println(Arrays.toString(row));
    // }

    if (dpBol[splitLoot][n]) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }

    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= splitLoot; j++) {
    // if (j >= value[i - 1]) {
    // dp[i][j] = Math.max(dp[i - 1][j - value[i - 1]] + value[i - 1], dp[i -
    // 1][j]);
    // } else {
    // dp[i][j] = dp[i - 1][j];
    // }
    // if (dp[i][j] == splitLoot)
    // count++;
    // }
    // }

    // System.out.println(Arrays.toString(b));
    // for (int[] row : dp) {
    // // System.out.print(a[k++]);
    // System.out.println(Arrays.toString(row));
    // }

    // Back track
    // int[] backTrack = new int[value.length];
    // int p = value.length-1;
    // int x = value.length, y = splitLoot;
    // while (x > 0) {
    // while (y > 0) {
    // if(dp[x][y] == dp[x-1][y]){
    // backTrack[p] = 0;
    // x--;
    // } else {
    // backTrack[p] = 1;
    // x--;
    // y = y-value[x];
    // System.out.println("Value " + value[x] + " Weight " + value[x]);
    // }
    // p--;
    // }
    // }

    // if (count < 3) {
    // System.out.println(0);
    // } else {
    // System.out.println(1);
    // }
    scanner.close();
  }
}

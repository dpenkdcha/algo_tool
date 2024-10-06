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

    int W = sum / 3;
    int count = 0;

    Arrays.sort(value);

    // boolean[][] dpBol = new boolean[splitLoot + 1][n + 1];

    // for (int i = 0; i <= n; i++)
    // dpBol[0][i] = true;

    // for (int i = 1; i <= splitLoot; i++)
    // dpBol[i][0] = false;

    // for (int i = 1; i <= splitLoot; i++) {
    // for (int j = 1; j <= n; j++) {
    // dpBol[i][j] = dpBol[i][j - 1];
    // if (i >= value[j - 1])
    // dpBol[i][j] = dpBol[i][j] || dpBol[i - value[j - 1]][j - 1];
    // }
    // }

    // // for (boolean[] row : dpBol) {
    // // // System.out.print(a[k++]);
    // // System.out.println(Arrays.toString(row));
    // // }

    // if (dpBol[splitLoot][n]) {
    // System.out.println(1);
    // } else {
    // System.out.println(0);
    // }

    int[][] dp = new int[W + 1][n + 1];
    boolean[] used = new boolean[n];

    for (int i = 1; i <= W; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = dp[i][j - 1];
        if (value[j - 1] <= i && !used[j - 1]) {
          int temp = dp[i - value[j - 1]][j - 1] + value[j - 1];
          if (temp > dp[i][j]) {
            dp[i][j] = temp;
          }
        }
      }
    }

    // // Print the table
    // System.out.println("Table showing the knapsack values:");
    // System.out.print("i \\ j\t");
    // for (int j = 1; j <= n; j++) {
    //   System.out.print(value[j - 1] + "\t"); // Print item weights as headers
    // }
    // System.out.println();

    // for (int i = 1; i <= W; i++) {
    //   System.out.print(i + "\t"); // Print weight 'i' as the row label
    //   for (int j = 1; j <= n; j++) {
    //     System.out.print(dp[i][j] + "\t"); // Print the value[i][j] entry
    //   }
    //   System.out.println();
    // }

    // Back track
    int[] backTrack = new int[value.length];
    int k = value.length;
    while (dp[W][k] == W) {
      int i = W, j = k;
      int splitSum = 0;
      
      while (i > 0 && j > 0) {
        if (backTrack[j - 1] == 0 && i >= value[j - 1]) {
          // System.out.println("dp[" + i + "][" + j + "] " + dp[i][j] + " Weight " + value[j - 1]);
          splitSum = splitSum + value[j - 1];
          backTrack[j - 1] = 1;
          i = i - value[j - 1];
        }
        j--;
      }

      if (splitSum == W) {
        count++;
      }
      k--;
    }

    // System.out.println("Count " + count);
    // System.out.println(Arrays.toString(backTrack));

    if (count == 3) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
    scanner.close();
  }
}

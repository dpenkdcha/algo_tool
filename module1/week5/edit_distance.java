package module1.week5;

import java.util.Scanner;

// 5-3: Edit Distance
public class edit_distance {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String firstString = scanner.next();
    String secondString = scanner.next();
    int fl = firstString.length();
    int sl = secondString.length();
    int[][] dp = new int[fl + 1][sl + 1];
    char[] c1 = new char[fl + 1];
    char[] c2 = new char[sl + 1];

    for (int i = 1; i <= fl; i++) {
      c1[i] = firstString.charAt(i - 1);
      dp[i][0] = i;
    }

    for (int j = 1; j <= sl; j++) {
      c2[j] = secondString.charAt(j - 1);
      dp[0][j] = j;
    }

    for (int j = 1; j <= sl; j++) {
      for (int i = 1; i <= fl; i++) {
        if (c1[i] == c2[j]) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = getMin(dp, i, j);
        }

        // for (int[] row : dp)
        // System.out.println(Arrays.toString(row));
      }
    }

    // System.out.println(Arrays.toString(c2));
    // int k = 0;
    // for (int[] row : dp) {
    // System.out.print(c1[k++]);
    // System.out.println(Arrays.toString(row));
    // }

    System.out.println(dp[fl][sl]);

    // backtrack to print the path

    scanner.close();
  }

  private static int getMin(int[][] dp, int i, int j) {
    if (dp[i - 1][j] > dp[i - 1][j - 1] && dp[i][j - 1] > dp[i - 1][j - 1])
      return dp[i - 1][j - 1] + 1;
    else if (dp[i - 1][j] > dp[i][j - 1])
      return dp[i][j - 1] + 1;
    else
      return dp[i - 1][j] + 1;
  }
}

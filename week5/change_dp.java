package week5;

import java.util.Arrays;
import java.util.Scanner;

// 5-1: Money Change Again
public class change_dp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int money = scanner.nextInt();
    int[] coins = { 1, 3, 4 };

    int count = changeCount(money, coins);

    System.out.println(count);

    scanner.close();
  }

  private static int changeCount(int money, int[] coins) {
    if (money == 0)
      return 0;

    int[] dp = new int[money + 1];
    Arrays.fill(dp, money + 1);
    dp[0] = 0;
    for (int i = 1; i <= money; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    return dp[money];
  }
}

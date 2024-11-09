package module1.week5;

import java.util.Scanner;

// 5-2: Primitive Calculator
public class primitive_calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] dp = new int[n + 1];

    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i <= n; i++)
      if (i % 3 == 0)
        dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
      else if (i % 2 == 0)
        dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
      else
        dp[i] = dp[i - 1] + 1;

    System.out.println(dp[n]);

    int x = n;
    String output = String.valueOf(x);
    while (x > 1) {
      if (x % 3 == 0 && dp[x / 3] < dp[x - 1])
        x = x / 3;
      else if (x % 2 == 0 && dp[x / 2] < dp[x - 1])
        x = x / 2;
      else
        x = x - 1;
      output = String.join(" ", String.valueOf(x), output);
    }

    System.out.println(output);
    scanner.close();
  }

}

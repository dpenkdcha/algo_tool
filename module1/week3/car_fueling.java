package module1.week3;

import java.util.Scanner;

// 3-3: Car Fueling
public class car_fueling {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int d = scanner.nextInt();
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[] stop = new int[n + 2];
    int refill = 0;

    stop[0] = 0;
    for (int i = 1; i <= n; i++) {
      stop[i] = scanner.nextInt();
    }
    stop[n + 1] = d;

    int refillAt = 0;
    while (refillAt < stop.length - 1) {
      int lastRefill = refillAt;

      while (refillAt < stop.length - 1 && stop[refillAt + 1] - stop[lastRefill] <= m) {
        refillAt++;
      }

      if (lastRefill == refillAt) {
        refill = -1;
        break;
      }

      if (refillAt < stop.length-1) {
        refill++;
      }
    }

    System.out.println(refill);
    scanner.close();

  }
}


import java.util.Scanner;

// 3-3: Car Fueling
public class car_fueling {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int d = scanner.nextInt();
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[] stop = new int[n + 1];
    int refill = 0;

    stop[0] = 0;
    for (int i = 1; i <= n; i++) {
      stop[i] = scanner.nextInt();
    }

    if (d > m) {
      if ((stop[0] > m) || (d - stop[n - 1] > m)) {
        refill = -1;
      } else {
        int refillAt = 0;
        while (refillAt < stop.length-1) {
          int lastRefill = refillAt;

          while (refillAt < stop.length-1 && stop[refillAt + 1] - stop[lastRefill] <= m) {
            refillAt++;
          }

          if (lastRefill == refillAt) {
            refill = -1;
          }

          if (refillAt < stop.length) {
            refill++;
          }

        }
      }
    }

    System.out.println(refill);

  }
}

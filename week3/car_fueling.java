package week3;

import java.util.Scanner;

// 3-3: Car Fueling
public class car_fueling {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int d = scanner.nextInt();
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[] stop = new int[n];
    int refill = 0;

    for (int i = 0; i < n; i++) {
      stop[i] = scanner.nextInt();
    }

    if (d > m) {
      refill = d / m;
      refill = refill-1;
      if (d % m > 0) {
        refill = refill + 1;
      }

      if(d - stop[n-1] > m) {
        refill = -1;
      }

      for (int i = 1; i < n; i++) {
        if(stop[i] - stop[i-1] > m) {
          refill = -1;
        }
      }
    }

    System.out.println(refill);

  }
}

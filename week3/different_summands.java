package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 3-6: Maximum Number of Prizes (Different Summands)
public class different_summands {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    // long[] k = new long[(int) (n + 1)];
    // long count = 1;
    // int kIndex = 1;
    // while (n > 0) {
    // if (((n - count) > k[kIndex - 1]) || ((n - count) == 0)) {
    // k[kIndex] = count;
    // n = n - count;
    // count++;
    // kIndex++;
    // } else if ((n - count) < 0) {
    // long negativeVal = n - count;
    // for (int j = 0; j < count; j++) {
    // if (k[j] + negativeVal == 0) {
    // k[j] = count;
    // n = n - count;
    // break;
    // }
    // }
    // } else {
    // count++;
    // }
    // }

    int price = 1;
    List<Integer> summands = new ArrayList<>();
    while (n > 0) {
      if (n <= price * 2) {
        summands.add(n);
        n -= n;
      } else {
        summands.add(price);
        n -= price;
        price++;
      }
    }


    System.out.println(summands.size());
    for (Integer integer : summands) {
      System.out.print(integer + " ");
    }
    scanner.close();
  }
}

package module1.week3;

import java.util.Scanner;

// 3-1: Money Change
public class change {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(((n/10) + (n%10)/5 + (n%5)));
    scanner.close();

    // int m = n;
    // int coinCount = 0;
    // while (n > 0) {
    //   if (n >= 10) {
    //     coinCount = coinCount + 1;
    //     n = n - 10;
    //   } else if (n >= 5) {
    //     coinCount = coinCount + 1;
    //     n = n - 5;
    //   } else if (n >= 1) {
    //     coinCount = coinCount + 1;
    //     n = n - 1;
    //   }
    // }

    // System.out.println(coinCount);
  }

}

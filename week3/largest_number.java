package week3;

import java.util.Scanner;

// 3-7: Maximum Salary (Largest Number)
public class largest_number {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] number = new String[n];
    String[] sortedNumber = new String[n];

    for (int i = 0; i < n; i++) {
      number[i] = String.valueOf(scanner.nextInt());
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (Integer.parseInt(number[i] + number[j]) < Integer.parseInt(number[j] + number[i])) {
          String temp = number[j];
          number[j] = number[i];
          number[i] = temp;
        }
      }
    }

    String cNumber = "";
    for (int i = 0; i < n; i++) {
      cNumber += number[i];
    }

    long cNum = Long.parseLong(cNumber);
    if (cNum == 0) {
      System.out.println("0");
    } else {
      cNumber = cNumber.replaceFirst("^0+", "");
      System.out.println(cNum);
    }

  }

}

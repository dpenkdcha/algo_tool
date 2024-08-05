package week3;

import java.util.Scanner;

// 3-7: Maximum Salary (Largest Number)
public class largest_number {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] number = new String[n];

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

    cNumber = cNumber.replaceFirst("^0+", "");
    System.out.println(cNumber);

    if (cNumber.equals("")) {
      System.out.println("0");
    }
    scanner.close();
  }

}

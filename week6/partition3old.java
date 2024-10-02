package week6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 6-2: Partitioning Souvenirs
public class partition3old {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int sum = 0;
    int[] value = new int[n];
    for (int i = 0; i < n; i++) {
      int x = scanner.nextInt();
      value[i] = x;
      sum += x;
    }

    if (n < 3) {
      System.out.println(0);
      scanner.close();
      return;
    }

    if (sum % 3 != 0) {
      System.out.println(0);
      scanner.close();
      return;
    }

    Arrays.sort(value);

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(value[i], map.getOrDefault(value[i], 0) + 1);
    }

    int N = n;
    int splitLoot = sum / 3;
    int calculateSplit = 0;
    int count = 0;
    while (map.size() > 0 && N > 0) {
      if (map.getOrDefault(value[N - 1], 0) >= 1) {
        if ((value[N - 1] + calculateSplit) <= splitLoot) {
          calculateSplit = value[N - 1] + calculateSplit;
          // System.out.println("calculateSplit " + calculateSplit);
          if (map.get(value[N - 1]) == 1) {
            map.remove(value[N - 1]);
          } else {
            map.put(value[N - 1], map.get(value[N - 1]) - 1);
          }
        }

        N--;
        if (splitLoot == calculateSplit) {
          N = n;
          calculateSplit = 0;
          count++;
        }
      } else {
        N--;
      }
    }

    if (count == 3) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
    scanner.close();
  }
}

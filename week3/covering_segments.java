package week3;

import java.util.Scanner;

// 3-5: Collecting Signatures (Covering Segments by Points)
public class covering_segments {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] fPoint = new int[n];
    int[] lPoint = new int[n];
    int[] points = new int[n];
    int touchedCount = 0;

    for (int i = 0; i < n; i++) {
      fPoint[i] = scanner.nextInt();
      lPoint[i] = scanner.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (lPoint[i] > lPoint[j]) {
          int temp = lPoint[j];
          lPoint[j] = lPoint[i];
          lPoint[i] = temp;

          int temp1 = fPoint[j];
          fPoint[j] = fPoint[i];
          fPoint[i] = temp1;
        }
      }
    }

    int point = lPoint[0];
    points[touchedCount] = point;
    touchedCount++;
    for (int i = 0; i < n; i++) {
      if(point < fPoint[i]) {
        point = lPoint[i];
        points[touchedCount] = point;
        touchedCount++;
      }
    }

    System.out.println(touchedCount);
    for (int i = 0; i < touchedCount; i++) {
      System.out.print(points[i] + " ");
    }
    scanner.close();
  }
}
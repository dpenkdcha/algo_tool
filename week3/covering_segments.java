package week3;

import java.util.Scanner;

// 3-5: Collecting Signatures (Covering Segments by Points)
public class covering_segments {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] fPoint = new int[n];
    int[] lPoint = new int[n];
    boolean[] touched = new boolean[n];
    int[] points = new int[n];
    int touchedCount = 0;

    for (int i = 0; i < n; i++) {
      fPoint[i] = scanner.nextInt();
      lPoint[i] = scanner.nextInt();
    }

    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // if (fPoint[i] > fPoint[j]) {
    // int temp = fPoint[j];
    // fPoint[j] = fPoint[i];
    // fPoint[i] = temp;

    // int temp1 = lPoint[j];
    // lPoint[j] = lPoint[i];
    // lPoint[i] = temp1;
    // }

    // }
    // }

    for (int i = 0; i < n; i++) {
      if (touched[i] == false) {
        int maxTouched = 0;
        for (int j = fPoint[i]; j <= lPoint[i]; j++) {
          int howManyTouched = 0;
          for (int k = i + 1; k < n; k++) {
            if (j >= fPoint[k] && j <= lPoint[k]) {
              touched[k] = true;
              howManyTouched++;
            }
          }
          if (maxTouched < howManyTouched) {
            maxTouched = howManyTouched;
            points[touchedCount] = j;
          }
        }
        touchedCount++;
      }
    }

    // for (int i = 0; i < n; i++) {
    // if (touched[i] == false) {
    // for (int j = i + 1; j < n; j++) {
    // if (touched[j] == false && lPoint[i] >= fPoint[j] && lPoint[i] <= lPoint[j])
    // {
    // touched[j] = true;
    // }
    // }
    // points[touchedCount] = lPoint[i];
    // touchedCount++;
    // }
    // }

    System.out.println(touchedCount);
    for (int i = 0; i < touchedCount; i++) {
      System.out.print(points[i] + " ");
    }
  }
}
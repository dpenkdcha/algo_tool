package week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 4-6: Organizing a Lottery
public class points_and_segments {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    Segment[] segments = new Segment[n];
    for (int i = 0; i < n; i++) {
      Segment segemnt = new Segment(scanner.nextInt(), scanner.nextInt());
      segments[i] = segemnt;
    }

    int[] points = new int[m];
    Integer[] pointsIndex = new Integer[m];
    for (int j = 0; j < m; j++) {
      points[j] = scanner.nextInt();
      pointsIndex[j] = j;
    }

    Arrays.sort(segments, 0, n, new SegmentFirstPointComparator());
    Arrays.sort(pointsIndex, Comparator.comparingInt(i -> points[i]));

    int segmentIndex = 0;
    int[] storeCount = new int[m];
    for (int i = 0; i < m; i++) {
      int point = points[pointsIndex[i]];

      while (segmentIndex < n && segments[segmentIndex].lastPoint < point) {
        segmentIndex++;
      }

      // Count how many segments cover this point
      int count = 0;
      int tempIndex = segmentIndex;
      while (tempIndex < n && segments[tempIndex].firstPoint <= point) {
        if (segments[tempIndex].lastPoint >= point) {
          count++;
        }
        tempIndex++;
      }
      storeCount[pointsIndex[i]] = count;
    }

    for (int count : storeCount) {
      System.out.print(count + " ");
    }

    scanner.close();
  }
}

class Segment {
  final int firstPoint;
  final int lastPoint;

  public Segment(int firstPoint, int lastPoint) {
    this.firstPoint = firstPoint;
    this.lastPoint = lastPoint;
  }
}

class SegmentFirstPointComparator implements Comparator<Segment> {
  @Override
  public int compare(Segment segemntA, Segment segemntB) {
    return Integer.compare(segemntA.firstPoint, segemntB.firstPoint);
  }
}

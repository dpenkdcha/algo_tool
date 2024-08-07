package week4;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 4-7:Closest Points
public class closest {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Point[] pointList = new Point[n];
    for (int i = 0; i < n; i++) {
      pointList[i] = new Point(scanner.nextInt(), scanner.nextInt());
    }

    Arrays.sort(pointList, 0, n, new PointXComparator());

    DecimalFormat df = new DecimalFormat("#.######");
    float closestDistance = findClosest(pointList, 0, n);

    System.out.println(df.format(closestDistance));

    scanner.close();
  }

  private static float findClosest(Point[] points, int lo, int hi) {
    if ((hi - lo) <= 3) {
      return bruteForce(points, hi);
    }

    int mid = lo + (hi - lo) / 2;
    Point midPoint = points[mid];

    float dl = findClosest(points, hi, mid);
    float dr = findClosest(points, mid, hi);

    float d = Math.min(dl, dr);

    Point strip[] = new Point[hi];
    int j = 0;
    for (int i = 0; i < hi; i++) {
      if (Math.abs(points[i].x - midPoint.x) < d) {
        strip[j] = points[i];
        j++;
      }
    }

    return Math.min(d, stripClosest(strip, j, d));
  }

  public static float bruteForce(Point[] P, int n) {
    float min = Float.MAX_VALUE;
    float currMin = 0;

    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        currMin = dist(P[i], P[j]);
        if (currMin < min) {
          min = currMin;
        }
      }
    }
    return min;
  }

  public static float dist(Point p1, Point p2) {
    return (float) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
        (p1.y - p2.y) * (p1.y - p2.y));
  }

  public static float stripClosest(Point[] strip, int size, float d) {
    float min = d; // Initialize the minimum distance as d

    Arrays.sort(strip, 0, size, new PointYComparator());

    for (int i = 0; i < size; ++i) {
      for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
        if (dist(strip[i], strip[j]) < min) {
          min = dist(strip[i], strip[j]);
        }
      }
    }

    return min;
  }
}

class Point {
  final int x;
  final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class PointXComparator implements Comparator<Point> {
  @Override
  public int compare(Point pointA, Point pointB) {
    return Integer.compare(pointA.x, pointB.x);
  }
}

class PointYComparator implements Comparator<Point> {
  @Override
  public int compare(Point pointA, Point pointB) {
    return Integer.compare(pointA.y, pointB.y);
  }
}

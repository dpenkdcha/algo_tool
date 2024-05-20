import java.util.Scanner;

public class maximum_pairwise_product {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] numbs = new int[n];
    int high = 0;
    int sHigh = 0;
    int highPosition = -1;
    for (int i = 0; i < n; i++) {
      numbs[i] = scanner.nextInt();
      if (i > 1 && numbs[i] > numbs[i - 1]) {
        high = numbs[i];
        highPosition = i;
      }
    }

//    System.out.println(" " + high + " " + highPosition);
    for (int x = 0; x < n - 1; x++) {
      if (numbs[x] > numbs[x + 1] && numbs[x] <= high && highPosition != x) {
        sHigh = numbs[x];
      } else if (numbs[x + 1] <= high && highPosition != x + 1) {
        sHigh = numbs[x + 1];
      }
    }
    System.out.println(high * sHigh);
  }
}
import java.util.Scanner;

public class maximum_pairwise_product {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] numbs = new int[n];
    int high = -1;
    int sHigh = -1;
    int highPosition = -1;
    for (int i = 0; i < n; i++) {
      numbs[i] = scanner.nextInt();
      if (numbs[i] > high) {
        high = numbs[i];
        highPosition = i;
      }
    }

//    System.out.println(" " + high + " " + highPosition);
    for (int x = 0; x < n; x++) {
      if (numbs[x] <= high && highPosition != x && numbs[x] > sHigh) {
        sHigh = numbs[x];
      }
    }
    System.out.println(high * sHigh);
  }
}
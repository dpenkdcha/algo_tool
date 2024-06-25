package week3;

import java.util.Scanner;

// 3-2: Maximum Value of the Loot (Fractional Knapsack)
public class fractional_knapsack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int W = scanner.nextInt();
		int[] value = new int[n];
		int[] weight = new int[n];
		double[] perUnitValue = new double[n];
		int[] indx = new int[n];

		for (int i = 0; i < n; i++) {
			int tValue = scanner.nextInt();
			int tWeight = scanner.nextInt();
			value[i] = tValue;
			weight[i] = tWeight;
			perUnitValue[i] = (double) tValue / (double) tWeight;
			indx[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (perUnitValue[i] > perUnitValue[j]) {
					double temp = perUnitValue[j];
					perUnitValue[j] = perUnitValue[i];
					perUnitValue[i] = temp;

					int temp1 = indx[j];
					indx[j] = indx[i];
					indx[i] = temp1;
				}
			}
		}

		int count = n;
		double totalValue = 0;
		while (W > 0 && count > 0) {
			if (W >= weight[indx[count - 1]]) {
				totalValue = totalValue + value[indx[count-1]]; //(perUnitValue[count - 1] * weight[indx[count - 1]]);
				W = W - weight[indx[count - 1]];
			} else {
				totalValue = totalValue + perUnitValue[count - 1] * W;
				W = 0;
			}
			count--;
		}

		System.out.println(String.format("%.4f", totalValue));
	}

}

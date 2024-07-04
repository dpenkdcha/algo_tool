package tmp;

public class test {
    public static void main(String[] args) {
        
        int[] perUnitValue = new int[] {
               5,6,9,0, 3, 2, 5, 1, 4, 7
        };

        // 3 2 5 1 4 // 2 3 5 1 4 // 1 3 5 2 4

        // 0 1 2 3 4 // 1 0 2 3 4 // 3 0 2 1 4
        for (int i = 0; i < perUnitValue.length; i++) {
            for (int j = i + 1; j < perUnitValue.length; j++) {
                if (perUnitValue[i] > perUnitValue[j]) {
                    int temp = perUnitValue[j];
                    perUnitValue[j] = perUnitValue[i];
                    perUnitValue[i] = temp;
                }
            }

        }
        for (int i = 0; i < perUnitValue.length; i++)
            System.out.println(perUnitValue[i]);
    }
}

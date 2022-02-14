package sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Time Complexity: O(n*n). Worst case occurs when array is reverse sorted. Best case when it's already sorted.
     * Auxiliary Space: O(1)
     */
    private static void sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            boolean swap = false;
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 4, 5};
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

package sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Time Complexity: O(n2) as there are two nested loops.
     * Auxiliary Space: O(1)
     * The good thing about selection sort is it never makes more than O(n)
     * swaps and can be useful when memory write is a costly operation.
     * Does not depend on sorting of elements.
     */
    private static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int k = i;

            for (int j = i; j < array.length; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }

            if (k != i) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 3, 4, 5 };
        SelectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}

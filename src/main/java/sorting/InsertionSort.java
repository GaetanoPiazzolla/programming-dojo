package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    // very good for partially sorted list and small lists.
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j;
            for (j = i-1; j >= 0 && array[j] > current; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = current;
        }
    }

}

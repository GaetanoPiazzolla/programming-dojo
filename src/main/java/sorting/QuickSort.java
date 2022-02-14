package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    // overloading
    private static void sort(int[] array) {
        sort(array,0,array.length-1);
    }

    private static void sort(int[] array, int lowIndex, int highIndex) {
        if (highIndex <= lowIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftIndex = partition(array, lowIndex, highIndex, pivot);

        sort(array, lowIndex, leftIndex - 1);
        sort(array, leftIndex + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[leftIndex] <= pivot) {
                leftIndex++;
            }
            while (leftIndex < rightIndex && array[rightIndex] >= pivot) {
                rightIndex--;
            }
            swap(array, leftIndex, rightIndex);
        }
        swap(array, leftIndex, highIndex);
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }



}

package sorting;

import java.util.Arrays;

public class MergeSort {


    // Time: o(n*log(n))
    // Space: o(n)

    // It goes through the whole process even if the array is sorted.
    public static void main(String[] args) {

        int[] array = new int[]{5,4,3,2,1};
        array = mergeSort(array);
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]+"-");
        }

        array = new int[]{5,4,3,2,1,234,23,423,2,2,1,24,1,3,14,5324,5234,52,45,1,36,42,13,5,124,53,46,53,134,53145316,47645,2};
        array = mergeSort(array);
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]+"-");
        }


    }

    private static int[] mergeSort(int[] array) {
        return sort(array);
    }


    private static int[] sort(int arr[])
    {
        if (arr.length > 1) {

            // Find the middle point
            int m = arr.length / 2;

            // Sort first and second halves
            int[] arr1 = sort(Arrays.copyOfRange(arr, 0, m));
            int[] arr2 = sort(Arrays.copyOfRange(arr, m, arr.length));

            // Merge the sorted halves
            return twoFingerMerge(arr1,arr2);
        }
        else{
            return arr;
        }
    }
 
    private static int[] twoFingerMerge(int[] array1, int[] array2) {

        int[] array3 = new int[array1.length + array2.length];

        int j=0; int i=0; int k=0;

        while( j< array2.length && i < array1.length && k < array3.length)
        {
            if(array1[i] < array2[j])
            {
                array3[k] = array1[i];
                i++;
            }
            else{
                array3[k] = array2[j];
                j++;
            }
            k++;
        }

        while(j<array2.length){
            array3[k] = array2[j];
            j++;k++;
        }

        while(i<array1.length){
            array3[k] = array1[i];
            i++;k++;
        }
        
        return array3;
        
    }


}

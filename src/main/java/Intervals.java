public class Intervals {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 12, 42, 70, 36, -4, 43, 15}, new int[]{5, 15, 44, 72, 36, 2, 69, 24}));

    }

    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8

        if (A == null || A.length == 0) {
            return 0;
        }

        quickSort(A, B, 0, A.length - 1);

        int interval = 0;

        for (int i = 0; i < A.length; i++) {

            int max = B[i];

            while (i < A.length - 1 && max >= A[i + 1]) {
                if (B[i + 1] > max) {
                    max = B[i + 1];
                }
                i++;

            }

            interval++;
        }

        return interval;
    }


    public static void quickSort(int[] arr, int[] arr2, int start, int end) {

        int partition = partition(arr, arr2, start, end);

        if (partition - 1 > start) {
            quickSort(arr, arr2, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, arr2, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int[] arr2, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {

                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;

                temp = arr2[start];
                arr2[start] = arr2[i];
                arr2[i] = temp;

                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        temp = arr2[start];
        arr2[start] = arr2[end];
        arr2[end] = temp;

        return start;
    }


}

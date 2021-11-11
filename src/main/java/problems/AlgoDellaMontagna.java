package problems;

public class AlgoDellaMontagna {

    /**
     * Dato un array di interi, verificare se si tratta di un array con una MONTAGNA.
     * <p>
     * Esiste un elemento dell'array tale che
     * <p>
     * tutti gli elementi precedenti sono inferiori
     * <p>
     * tutti gli elementi successivi sono maggiori
     * arr[0] < arr[1] < ... < arr[i - 1] < A[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * <p>
     * Example 1:
     * Input: arr = [2,1]
     * Output: false
     * <p>
     * Example 2:
     * Input: arr = [3,5,5]
     * Output: false
     * <p>
     * Example 3:
     * Input: arr = [0,3,2,1]
     * Output: true
     */
    public static boolean checkMontagna(int[] arr) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("false: " + checkMontagna(new int[]{2, 1}));
        System.out.println("false: " + checkMontagna(new int[]{3, 5, 5}));
        System.out.println("false: " + checkMontagna(new int[]{0, 3, 3, 1}));
        System.out.println("false: " + checkMontagna(new int[]{3, 1, 3, 1}));

        System.out.println("false: " + checkMontagna(new int[]{0, 1, 2}));
        System.out.println("false: " + checkMontagna(new int[]{0, 1, 2, 3, 4, 5, 5, 3, 2, 1, 0}));

        System.out.println("true: " + checkMontagna(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}));
        System.out.println("true: " + checkMontagna(new int[]{0, 3, 2, 1}));

    }


}

package easy;

import java.util.Arrays;

public class WeakestRows {


    public static int[] kWeakestRows(int[][] mat, int k) {

        int[] soldiers = new int[mat.length];
        for(int i=0; i<mat.length;i++) {
            soldiers[i] = 0;
            for(int j=0;j<mat[i].length;j++) {
                if(mat[i][j] == 1) {
                    soldiers[i]++;
                }
            }
        }

        int[] orderedSoldiers = Arrays.copyOf(soldiers,soldiers.length);
        Arrays.sort(orderedSoldiers);

        int[] weakestRows = new int[k];

        for(int i=0;i<k;i++) {
            for(int j=0; j<mat.length; j++) {
                if(orderedSoldiers[i] == soldiers[j]){
                    weakestRows[i] = j;
                    soldiers[j] = -1;
                    break;
                }
            }
        }

        return weakestRows;
    }

    public static void main(String[] args) {

        /**
         * [[1,1,0,0,0],
         *  [1,1,1,1,0],
         *  [1,0,0,0,0],
         *  [1,1,0,0,0],
         *  [1,1,1,1,1]]
         */
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,1,0,0,0};
        matrix[1] = new int[]{1,1,1,1,0};
        matrix[2] = new int[]{1,0,0,0,0};
        matrix[3] = new int[]{1,1,0,0,0};
        matrix[4] = new int[]{1,1,1,1,1};

        System.out.println(Arrays.toString(WeakestRows.kWeakestRows(matrix,3)));

    }

}

public class SpiralMatrixII {

    /**
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     * 1 <= n <= 20
     */

    /**
     * Input: n = 3
     * Output: [[1,2,3],[8,9,4],[7,6,5]]
     *
     * Input: n = 1
     * Output: [[1]]
     */
    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int value = 1;
        int totNumbers = n * n;

        int right =n;
        int bottom=n;
        int left=0;
        int top=0;

        matrix[0][0] = value;

        int y=0 , x=0;

        while (value < totNumbers) {

            while(x < right - 1){
                x++;
                matrix[y][x] = ++value;
            }
            top++;

            while(y < bottom - 1){
                y++;
                matrix[y][x] = ++value;
            }
            right--;

            while(x > left)
            {
                x--;
                matrix[y][x] = ++value;
            }
            bottom--;

            while(y > top)
            {
                y--;
                matrix[y][x] = ++value;
            }
            left++;
        }

        return matrix;
    }


    public static void main(String[] args) {

        int[][] matrix = generateMatrix(3);
        printMatrix(matrix);

        matrix = generateMatrix(10);
        printMatrix(matrix);

        matrix = generateMatrix(5);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                row.append(" ").append(matrix[i][j]);
            }
            System.out.println(row);

        }

    }

}

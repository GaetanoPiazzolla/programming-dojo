public class RotateMatrix90 {


    /*
    *   1   2   3   4  ->
    *   5   6   7   8
    *   9  10  11  12
    *   13 14  15  16
     */
    public void rotateMatrix(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix.length ==1 )
        {
            return;
        }

        int layers = matrix.length / 2;

        for(int layer=0 ; layer < layers; layer++){

            int first = layer;
            int last = matrix.length - layer -1;

            for(int i= first ; i < last; i++){

                // top
                int temp = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last-i-first][first];

                // bottom -> left
               // matrix[last-i-first][first] = matrix[]



            }


        }


    }
}

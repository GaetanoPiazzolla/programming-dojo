public class SpiralMatrixIII {

    private enum Direction {
        RIGHT, LEFT, UP, DOWN;
        private Direction next;
        static {
            RIGHT.next = DOWN;
            LEFT.next = UP;
            UP.next = RIGHT;
            DOWN.next = LEFT;
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i=0 ,j =0;
        Direction direction = Direction.RIGHT;
        for(int p=1; p<=n*n; p++) {
            if( matrix[i][j] != 0 ){
                break;
            }
            matrix[i][j] = p;
            direction = nextDirection(direction,i,j,n,matrix);
            switch(direction) {
                case RIGHT: j++; break;
                case LEFT: j--; break;
                case UP: i--; break;
                case DOWN: i++; break;
            }
        }
        return matrix;
    }

    private static Direction nextDirection(Direction currentDirection, int i, int j, int n, int[][] matrix) {
        Direction newDirection = currentDirection.next;
        int nextCol,nextRow;
        switch(currentDirection) {
            case RIGHT:
                nextCol = j+1;
                if(nextCol <n && matrix[i][nextCol]==0) {
                    newDirection = currentDirection;
                }
                break;
            case LEFT:
                nextCol = j-1;
                if(nextCol >= 0 && matrix[i][nextCol]==0) {
                    newDirection = currentDirection;
                }
                break;
            case UP:
                nextRow = i-1;
                if(nextRow >= 0 && matrix[nextRow][j]==0) {
                    newDirection = currentDirection;
                }
                break;
            case DOWN:
                nextRow = i+1;
                if(nextRow < n && matrix[nextRow][j]==0) {
                    newDirection = currentDirection;
                }
                break;
        }

        return newDirection;
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

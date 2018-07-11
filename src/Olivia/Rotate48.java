package Olivia;

public class Rotate48 {
    public void rotate(int[][] matrix) {
        //special cases
        if(matrix.length==0)
            return;
        //first,reverse from down to up
        for (int i = 0; i<matrix.length/2;i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = tmp;
        }
        //then, change i j
        for(int i = 0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }

}

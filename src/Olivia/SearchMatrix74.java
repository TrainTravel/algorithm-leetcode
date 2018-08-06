package Olivia;

public class SearchMatrix74 {
    /* not treat it as 2d, treat it as a sorted list */
    public boolean searchMatrix(int[][] matrix, int target) {
        /* special case for empty matrix */
        if(matrix.length == 0)
            return false;
        int num = matrix.length * matrix[0].length;
        int startLoc = 0;
        int endLoc = num-1;
        while(startLoc<=endLoc){
            int middleLoc = (startLoc + endLoc)/2;
            /* be careful about row and col */
            int mid_x = middleLoc/(matrix[0].length);
            int mid_y = middleLoc%(matrix[0].length);
            if(target==matrix[mid_x][mid_y]){
                return true;
            }
            else if(target>matrix[mid_x][mid_y]){
                startLoc = middleLoc + 1;
            }
            else{
                endLoc = middleLoc - 1;
            }
        }
        return false;
    }
}

package Olivia;

public class SolveSudoku37 {
    public void solveSudoku(char[][] board) {
        if(board==null)
            return;
        solveHelper(board);
    }
    private boolean solveHelper(char[][] board){
        for(int row=0;row<9;row++){
            for(int col = 0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char cur = '1'; cur<='9';cur++){
                        if(isValid(board,row,col,cur)){
                            board[row][col]=cur;
                            if(solveHelper(board)){
                                return true;
                            }
                            else{
                                board[row][col] = '.';
                            }
                        }
                    }
                    //very important
                    return false;
                }
            }

        }
        return true;
    }
    private boolean isValid(char[][]board, int row, int col, char cur){
        for(int i=0;i<9;i++){
            if(board[row][i]!='.'&&board[row][i]==cur)
                return false;
            if(board[i][col]!='.'&&board[i][col]==cur)
                return false;
            int box_row = 3*(row/3)+i/3;
            int box_col = 3*(col/3)+i%3;
            if(board[box_row][box_col]!='.'&&board[box_row][box_col]==cur)
                return false;
        }
        return true;
    }

}

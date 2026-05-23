
import java.util.*;

class N_Qeen_Problem{

    static int n;

    void printBoard(char[][] board){
        System.out.println("\n\n**Game Board**");
        for(char[] r: board){
            for(char c: r){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
     boolean isValid(char[][] board,int row ,int col){

        for(int i = 0 ; i < row ; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int r = row - 1, c = col -1 ; r >= 0 && c >= 0 ; r--,c--){
            if(board[r][c]=='Q'){
                return false;
            }
        }

        for( int r = row - 1, c = col+1 ; r >= 0 && c <n ; r--,c++){
            if(board[r][c]=='Q'){
                return false;
            }
        }

        return true;
    }

    
    boolean solve(char[][] board, int row){
        if(row == n){
            printBoard(board);
            return true;
        }

        for( int col = 0 ; col<n ; col++){

            if(isValid(board,row,col)){

                board[row][col] = 'Q';

                if(solve(board,row+1)){
                    return true;
                }

                board[row][col] = '.';

            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of board :");
        n = sc.nextInt();
        sc.close();

        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }

        N_Queen_Problem t = new N_Queen_Problem();
        if(!t.solve(board,0)){
            System.out.println("no solution exist!!!");
        }
    }
}

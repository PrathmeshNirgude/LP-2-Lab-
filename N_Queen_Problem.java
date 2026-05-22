
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
}

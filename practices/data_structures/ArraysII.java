import java.util.*;
/*
 *  You can move from index i to index i+1 , i-1 , i+leap or  as long as the destination index is a cell containing a ZERO.
 *  If the destination index is greater than lenght-1, you win the game.
 * 
******Input Format********

The first line contains an integer, q, denoting the number of queries
Each query described over two lines:

    The first line contains n two space-separated integers describing the respective values of n and  leap.
    The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of array

*/
import java.io.*;
import java.util.*;

public class ArraysII {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while ((q--) > 0) { //q is decremented right after condition check 
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game,0)) ? "YES" : "NO" );
        }
        scan.close();
    }
    
    public static boolean canWin(int leap, int[] game,int index) {
        // Return true if you can win the game; otherwise, return false.
        //if index is negative or doesn't contain return false cannot jump to that locatin 
       if(index<0|| game[index]!=0){
           return false;
       }
       //if current index contains zero and next step or index+leap is end of array return true you win the game
       
       if(index+1> game.length-1||index+leap>game.length-1){
           return true;
       }
       //set value of current idex as 1 since it's visited
       game[index]=1;
       // check wheter other possible steps for game
       return canWin(leap, game, index-1)||canWin(leap, game, index+1)||canWin(leap, game, index+leap);
    }
    
}

import java.io.*;
import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int i=0;
        int d;
        //REad the matrrix into 2d arraylist
        while(i<n){
            d = scanner.nextInt();
            int j=0;
            //Declare new arraylist for each row
            table.add(new ArrayList<Integer>());
            while(j<d){
                int num = scanner.nextInt();
                table.get(i).add(num);
                j++;
            }
            //System.out.println(table.get(i));
            i++;  
        }
       
        //Read the Queries
        int q= scanner.nextInt();
        while(q>0){
            int x= scanner.nextInt();
            int y= scanner.nextInt();
            if(table.get(x-1).size()>0 && x <= table.size() && y-1 < table.get(x-1).size()){
                System.out.println(table.get(x-1).get(y-1));            
            }   
            else{

                System.out.println("ERROR!");
            }
            q--;
        }        
    }
}

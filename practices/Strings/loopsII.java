import java.util.*;
import java.io.*;

class loopsII{
    public static void main(String []argh){
        Scanner scaned_input = new Scanner(System.in);
        int a,q,b,n,expr=0;
        q = scaned_input.nextInt();
        for (int i = 0; i < q; i++) {
                a = scaned_input.nextInt();
                b = scaned_input.nextInt();
                n = scaned_input.nextInt();
                for (int j = 0; j < n; j++) {
                    expr += (Math.pow(2, j) * b);
                    System.out.print(a+expr);
                    System.out.print(" ");
                }
                System.out.print("\n");
                expr=0;
            }
            scaned_input.close();
    }
}


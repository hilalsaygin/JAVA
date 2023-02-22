import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Arithmetic{
    int add(int v1, int v2){        
        return v1+v2;
    } 
}
class Adder extends Arithmetic{  
    public void print_addition(int v1,int v2){
        int res=this.add(v1,v2);
        System.out.print(res);
        System.out.print(" ");

    }
}

public class TestInheritanceII{
    public static void main(String []args){
        // Create a new Adder object
        Adder a = new Adder();
        
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());	
        
        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        a.print_addition(10,32);
        a.print_addition(10,3);
        a.print_addition(10,10);

    }
}
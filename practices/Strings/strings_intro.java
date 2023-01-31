import java.io.*;
import java.util.*;

public class strings_intro {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        //read input string on separate lines
        String a= scanner.nextLine();
        String b= scanner.nextLine();
        //store lenghts
        int len_a=a.length();
        int len_b=b.length();
        //print total lenght
        System.out.println(len_a+len_b);
        // compare inputs lexicographically
        int compare = a.compareTo(b);
        if(compare>0){
            System.out.println("Yes"); }
        else {
            System.out.println("No"); }
        //capatilize first letters wit help of String class methods substring() and toUpperCase()
        String a_out = a.substring(0, 1).toUpperCase() + a.substring(1);
        String b_out = b.substring(0, 1).toUpperCase() + b.substring(1);
        System.out.println(a_out+" "+b_out);
    }
}

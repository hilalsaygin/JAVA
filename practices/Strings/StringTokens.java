import java.io.*;
import java.util.*;
/*
 Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. 
 A token is defined as one or more consecutive English alphabetic letters. 
 Then, print the number of tokens, followed by each token on a new line.
 */
public class StringTokens {

    public static void main(String[] args) {
        System.out.println("Enter input to be tokenized: ");

        Scanner scan = new Scanner(System.in);
        if (!(scan.hasNext())) {
            System.out.println("0");
        } 
        else {
            String s_in = scan.nextLine();
            String reg_exp="[ -!,?._'@]+";

            split_into_tokens(s_in,reg_exp);
            scan.close();
            
        }
    }
    public static void split_into_tokens(String str, String reg){
        //practice usage of trim and split methods of String class
        String[] tokens = str.trim().split(reg);
            int len =tokens.length;
            System.out.println(len);

            for( String n : tokens ){
                System.out.println(n);
                    
            }
    }
}


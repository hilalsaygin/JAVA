import java.util.*;

// Detect if a given string is a ğalindrome or not 
public class StringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        boolean str_palindrome= is_palindrome(str);

       if(str_palindrome){
           System.out.println("Yes");
       }
       else{
           System.out.println("No");
       }  
       sc.close();
        
    }
    
    public static boolean is_palindrome(String str){
        String reverse="";
        
        for (int i =str.length()-1; i >=0; i--){
            reverse += str.charAt(i);
            
        }
        //check original string with reverse 
        if(str.equals(reverse)){
            return true;
        }
        else{
            return false;
        }
    }
}




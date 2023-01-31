import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    /*
     * regular expression for difined contraints;
     * a username is considered valid if all the following constraints are satisfied:
The username consists of 8 to 30 characters inclusively.
If the username consists of less than 8 or greater than 30 characters, then it is an invalid username.
The username can only contain alphanumeric characters and underscores (_). 
Alphanumeric characters describe the character set consisting of lowercase characters , uppercase characters , and digits .
The first character of the username must be an alphabetic character, i.e., either lowercase character  or uppercase character .
    */
     
    //reg exp variable defination

public class CheckUsername {

    public static final String regularExpression="^[a-zA-Z][a-zA-Z0-9_]{7,29}$";

    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            //read username input
            String userName = scan.nextLine();
            //check if given input is in the form of defined regular expression with mathes method os String class
            if (userName.matches(regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}
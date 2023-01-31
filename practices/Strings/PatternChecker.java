import java.util.Scanner;
import java.util.regex.*;

public class PatternChecker
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        //read number of input pattern
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0 && in.hasNextLine()){
            //read input regular expression pattern 
            String pattern = in.nextLine();
            // practice Pattern class and try-except blocks
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
                testCases--;
            } catch (Exception PatternSyntaxException ) {
                System.out.println("Invalid");
            }

        }
	}
}




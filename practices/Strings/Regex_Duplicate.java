import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * remove instances of words that are repeated more than once, but retain the first occurrence of any case-insensitive repeated word. 
 * For example, the words love and to are repeated in the sentence I love Love to To to code. 
 *Turn I love Love to To to, code into I love to code?

Write a RegEx that will match any repeated word.
Complete the second compile argument so that the compiled RegEx is case-insensitive.
Write the two necessary arguments for replaceAll such that each repeated word is replaced with the very first instance the word found in the sentence.
It must be the exact first occurrence of the word, as the expected output is case-sensitive.

 */
/*
 * INPUT FFORMAT
4
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe


 * OUTPUT FORMAT
Goodbye bye world
Sam went to his business
Reya is the best player in eye game
in inthe

*/

public class Regex_Duplicate {
//Practice usage of pattern and matcher classes
    public static void main(String[] args) {
        
        String regex ="\\b(\\w+)(?:\\W+\\1\\b)+";
        //Create Pattern class object for regex forming  from String object 
        Pattern reg_patern= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            //Create Matcher to find repeated regex in input 
            Matcher m = reg_patern.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                //mgroup() return the regex pattern as string 
                //m.group(int groupNo): Returns the matched sequence captured by the given group 
                input = input.replaceAll(m.group(), m.group(1)); 

            }
            System.out.println(input);            
        }
        in.close();
    }
}

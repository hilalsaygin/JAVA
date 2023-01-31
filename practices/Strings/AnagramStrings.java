import java.util.Scanner;

public class AnagramStrings {
       //To detect whether given string are anagram of each other or nor, sort strings then check if they are equal.
       // If so then they are anagram of each other since they should contain same letters at same count to be equal

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        //print Anagrams if ret variable is true otherwise Not Anagrams
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

        scan.close();
    }
        //Takes a string and returns a sorted string 
    public static String sort_string (String str){
        char temp;
        int len = str.length();
        int i=0, j=0;
        str=str.toLowerCase();
        char[] s_letters = str.toCharArray();
        
        
        while(i<len){
            j=i+1;
            while(j<len){
                if(s_letters[j]<s_letters[i]){
                    temp=s_letters[i];
                    s_letters[i]=s_letters[j];
                    s_letters[j]=temp;
                }
                j +=1;   
            }
            i+=1;
        }
        String sorted = new String(s_letters);
        return sorted;
        
    }
    
    public static boolean isAnagram(String str1, String str2) {
      
        String s1_sorted=sort_string(str1);
        String s2_sorted=sort_string(str2);
        //compare sorted strings 
        if(s1_sorted.equals(s2_sorted)){
            return true;
        }
        else{
            return false;

        }        
    }

}

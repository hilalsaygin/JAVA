import java.util.Scanner;

public class SubstringComparison {
    public static void  main (String[] args){
        System.out.print("Enter String and substirng lenght: ");
        try (Scanner scanner = new Scanner(System.in)) {
            //read input string on separate lines
            String string_in= scanner.nextLine();
            int sub_lenght= scanner.nextInt();
            if(sub_lenght< string_in.length())
                System.out.println(getSmallestAndLargest(string_in,sub_lenght));
            else
                System.out.println("Invalid Substring lenght");
        }

    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // 'smallest' is the lexicographically smallest substring of length 'k'
        // 'largest' is the lexicographically largest substring of length 'k'
        
        
        //The number of substrings of length k is n-k+1 where 1 <= k <= n.

        int sub_count= s.length() - k +1;
        
        //assume first substiring to be smallest and largest than compare with rest of the substring kenght k
        smallest=s.substring(0,k);
        largest=s.substring(0,k);
        
        for ( int i =1; i<sub_count; i++){
            //form the next substring 
            String sub_s=s.substring(i,i+k);
            //is new substring is lexicographically smaller than smallest assign it as smallest
            if((sub_s.compareTo(smallest)) <0){
                smallest = sub_s;
            }
            //if new substring is bigger assign as largest
            if (sub_s.compareTo(largest) >0 ){
                largest=sub_s;
            }
            
            
        }
        //concatenate smallest and largest
        return smallest + "\n" + largest;

    }
}


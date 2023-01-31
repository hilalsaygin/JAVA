    import java.io.*;
    import java.util.*;
    
    public class IP_Regex{
    
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()){
                String IP = in.nextLine();
                String reg_patt="(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
                if(IP.isEmpty())
                    break;
                check_ip_adress(IP,reg_patt);
              
            }
            in.close();
        }

        public static void check_ip_adress(String IP, String reg){
            String arr[] = IP.split("\\.",0);
            int counter=0;
            int arr_size=0;
            for (String s: arr){
                arr_size++;
                if (s.matches(reg)){
                    counter++;
                }
            }
            
            if(counter==4 && arr_size==4){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
        
    }
    
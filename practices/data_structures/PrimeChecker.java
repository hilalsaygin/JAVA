import java.io.*;
import java.util.*;

class PrimeChecker{
    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int[] inputs= new int[5];
        int index=0;
        
        while(in.hasNextInt()){    
            int num= in.nextInt();
            inputs[index]=num;            
            index++;
        }
        Prime.checkPrime(1,inputs[0]);
        Prime.checkPrime(2,inputs[0],inputs[1]);
        Prime.checkPrime(3,inputs[0],inputs[1],inputs[2]);
        Prime.checkPrime(5,inputs[0],inputs[1],inputs[2],inputs[3],inputs[4]);


        
        in.close();
        

    }

    public static void checkPrime(int len, int... inputs){
        boolean exist_prm=false;
        for (int n =0; n<len ;n++){
            boolean is_prm=true;
            for(int i=2; i<= inputs[n]/2; i++){
                if(inputs[n] % i == 0){
                is_prm= false;
                }
            }
            if(is_prm && inputs[n]>1){
                exist_prm=true;
                System.out.print((inputs[n]));
                System.out.print(" ");
            }
        }
        System.out.println("");

      
    }

}



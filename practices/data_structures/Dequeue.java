    import java.util.*;
    public class Dequeue {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            HashSet<Integer> int_set = new HashSet<>();

            int n = in.nextInt();
            int m = in.nextInt();
            int max_unique=0;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.add(num); 
                int_set.add(num);
                //if sub list lenght is read into deque control unique count
                if(deque.size()==m){
                    if(int_set.size() > max_unique){
                        max_unique=int_set.size();                        
                    }
                    int first=(int) deque.remove();
                    //if first of deque not in the deque already remove from set
                    if(!deque.contains(first)){
                        int_set.remove(first);
                    }
                    
                }  
            }
            
            System.out.println(max_unique);
            
        }
        
    }


//first check first ele of sub array and new element to be added is same if they are different then compare with rest of sub array elements. 
//if same unique num of elements in sub array won^t change 


String str_arr []= new String[];
System.out.println(Arrays.toString(str_arr));


String str_2d[][] = new String [3][];
String str_2d[0] = new String [3];


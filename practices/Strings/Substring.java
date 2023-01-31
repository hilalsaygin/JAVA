
import java.util.*;

public class Substring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str_in = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        //create a substring with characters between start end indexes
        String sub_str=str_in.substring(start,end);
        System.out.println(sub_str);
    }
    
}

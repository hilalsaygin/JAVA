import java.util.*;
class Stack_I{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.nextLine();
            
            if(paranthesis_is_balanced(input))
                System.out.println("true");
            else  
                System.out.println("false");
            
		}
		
	}
    
    public static boolean paranthesis_is_balanced(String input_str) {
        
        //declare stack
        Stack<Character> stack = new Stack<Character>();
        boolean ret_val=false;
        int str_len =input_str.length();
        if(str_len%2 ==0){
            //trverse string starting from begining
            for (int i = 0; i < str_len; i++) {
                char ch = input_str.charAt(i);
                //if char is opening parantheses push to stack
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } 
                else if (stack.empty()) {
                    return false;
                }
                //if current char is not opening paratheses and there is char in stack previoulsy pushed to stack then control if current char is closing parantheses if so retun true if not false 
                else {
                    char top = stack.pop();
                    if ((top == '(' && ch == ')') || (top == '[' && ch == ']')
                            || (top == '{' && ch == '}')) {
                        ret_val= true;
                    }
                    else if(ch == ')' || ch == ']' || ch == '}')
                        return false;
                }
            }
        }
        
        return ret_val;
    }
}

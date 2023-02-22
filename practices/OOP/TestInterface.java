import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}
//interfaces are special type of classes which contains only abstract methods.( only the declaration of methods no functionality)


//The methods declare in AdvancedArithmetic will be implemented by MyCalculator class which stated that it implements the interface
class MyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){
        
        int div_sum=0;
        for(int i=1; i<=n; i++){
            if( n%i == 0){
                div_sum+=i;
            }
        }
        return div_sum;
    }
}
class TestInterface{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames is a method that takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object obj){
        //get the implemented interfaces of the object 
        Class[] theInterfaces = obj.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}


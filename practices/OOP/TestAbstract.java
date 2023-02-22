import java.util.*;
abstract class Book{
	String title;
	abstract void setTitle(String s);
	String getTitle(){
		return title;
	}
	
}
//no instance can be created from abract class. methods in abstract class can be implemented in itself and its subclasses. 
//Abstract methods in abstract clasees needs to be implemented in child classes.
//Write MyBook class here
class MyBook extends Book{
    public void setTitle(String s){
        title=s;
    }
    
}

public class TestAbstract{
	
	public static void main(String []args){
		//Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		MyBook new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();
		
	}
}
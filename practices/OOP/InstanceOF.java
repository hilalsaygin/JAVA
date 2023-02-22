import java.util.*;


class Student{
   private String name;
   private int std_no;
   Student(String nm,int no){
      this.name=nm;
      this.std_no=no;
   }
   public int getNo(){
      return this.std_no;
   }
   public String getName(){
      return name;
   }
}
class Rockstar{
   private String name;
   private String music_genre;
   private int fan_amount;
   Rockstar(String name,String genre,int fan){
      this.name=name;
      this.music_genre=genre;
      this.fan_amount=fan;
   }

   public String getName(){
      return name;
   }
   public String getGenre(){
      return name;
   }
   public int getFan(){
      return fan_amount;
   }

   }
class Hacker{
   private String name;
   private float specialty_time;
   Hacker(String name, float specialty_time){
      this.name=name;
      this.specialty_time=specialty_time;

   }
}


public class InstanceOF{
	
   static String count(ArrayList mylist){
      int a = 0,b = 0,c = 0;
      for(int i = 0; i < mylist.size(); i++){
         Object element=mylist.get(i);
         if(element instanceof Student)
            a++;
         if(element instanceof Rockstar)
            b++;
         if(element instanceof Hacker)
            c++;
      }
      String ret = Integer.toString(a)+" "+ Integer.toString(b)+" "+ Integer.toString(c);
      return ret;
   }

   public static void main(String []args){
      ArrayList mylist = new ArrayList();
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      //count types in given arraylist
      for(int i=0; i<t; i++){
         String s=sc.next();
         if(s.equals("Student"))mylist.add(new Student());
         if(s.equals("Rockstar"))mylist.add(new Rockstar());
         if(s.equals("Hacker"))mylist.add(new Hacker());
      }
      System.out.println(count(mylist));
   }
}

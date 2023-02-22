import java.util.*;
class Sports{

    String getName(){
        return "Generic Sports";
    }
  
    void getNumberOfTeamMembers(){
        System.out.println( "Players in " + getName() + " should be specified" );
    }
}

class Soccer extends Sports{
    @Override
    String getName(){
        return "Soccer";
    }
    
    @Override
    void getNumberOfTeamMembers(){
        System.out.println( "Each " + getName() + " team has 11 players" );
    }

}
class Basketball extends Sports{
    @Override
    String getName(){
        return "Basketball";
    }
    
    @Override
    void getNumberOfTeamMembers(){
        System.out.println( "Each " + getName() + " team has 12 players " );
    }
}
public class TestOverriding{
    public static void main(String []args){
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        Basketball c3 = new Basketball();

        c1.getNumberOfTeamMembers();
        c2.getNumberOfTeamMembers();
        c3.getNumberOfTeamMembers();
	}
}

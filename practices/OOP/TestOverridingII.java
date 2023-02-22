import java.util.*;
import java.io.*;


class BiCycle{
	String define_vehicle(){
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle{
	String define_vehicle(){
		return "a cycle with an engine.";
	}
	// define contructor
	//super keyword for object creation of parent class
	// object of child class cannot be created without creating parent class instance
	MotorCycle(){
		String ancestor_ =super.define_vehicle();
		System.out.println("Hello I am a motorcycle, I am "+ define_vehicle());
		System.out.println("My ancestor is a cycle who is "+ ancestor_ );
	}
	
}
public class TestOverridingII{
	public static void main(String []args){
		//crate instance
		//defined contructor will be called directly
		MotorCycle M=new MotorCycle();
	}
}
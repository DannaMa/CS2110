
public class exceptionhandling {
public double p(int x){
	y=x;
	try{
		//y= 5/x;
		System.out.println("five");
		return 2/x;   //if 5/x is commented out, will 2/x trigger an exception??
	}catch(RuntimeException a){
		System.out.println("four");
		y= 5/(x+1);
		System.out.println("three");
	}
}
}
import static org.junit.Assert.*;

import org.junit.Test;

public class PHDTester {

	private PHD t1;
	private PHD t2;
	private PHD t3;
	
	@Test
	public void testConstructor() {
		//testA constructor,getter:name,gender,month,year,and boolean:isMale
		PHD t1 = new PHD("John",'m', 1985, 11);
		assertEquals("John",t1.getName());
		assertEquals(1985,t1.getYear());
		assertEquals(11,t1.getMonth());
		assertEquals(true,t1.isMale());
//		System.out.println("t1");
//		System.out.println("Gender=" + t1.isMale());
//		System.out.println("Name=" + t1.getName());
//		System.out.println("Year=" + t1.getYear());
//		System.out.println("Month=" + t1.getMonth());
		
		//testA constructor,getter:name,gender,month,year,and boolean:isMale
		PHD t2 = new PHD("Sally",'f', 2007, 10);
		assertEquals("Sally",t2.getName());
		assertEquals(2007,t2.getYear());
		assertEquals(10,t2.getMonth());
		assertEquals(false,t2.isMale());
//		System.out.println("t2");
//		System.out.println("Gender=" + t2.isMale());
//		System.out.println("Name=" + t2.getName());
//		System.out.println("Year=" + t2.getYear());
//		System.out.println("Month=" + t2.getMonth());
		
		/*testB constructor,getter:name,gender,month,year,
		 *boolean:isMale,and setAdvisor	*/	
		PHD t3 = new PHD("Kevin",'m', 2007, 10);
		assertEquals("Kevin",t3.getName());
		assertEquals(2007,t3.getYear());
		assertEquals(10,t3.getMonth());
		assertEquals(true,t3.isMale());
//		System.out.println("t3");
//		System.out.println("Gender=" + t3.isMale());
//		System.out.println("Name=" + t3.getName());
//		System.out.println("Year=" + t3.getYear());
//		System.out.println("Month=" + t3.getMonth());
		
		t3.setAdvisor1(t1);
		t3.setAdvisor2(t2);
		assertEquals(t1,t3.advisor1);
		assertEquals(t2,t3.advisor2);
//		System.out.println("Advisor1=" + t3.advisor1().getName());
//		System.out.println("Advisor2=" + t3.advisor2().getName());

		/*testC constructor,getter:name,gender,month,year,
		 *boolean:isMale,and setAdvisor*/			
		PHD t4 = new PHD("Marc",'m', 1997, 10, t1);
		assertEquals("Marc",t4.getName());
		assertEquals(1997,t4.getYear());
		assertEquals(10,t4.getMonth());
		assertEquals(true,t4.isMale());
		assertEquals(t1,t4.advisor1);
//		System.out.println("t4");
//		System.out.println("Gender=" + t4.isMale());
//		System.out.println("Name=" + t4.getName());
//		System.out.println("Year=" + t4.getYear());
//		System.out.println("Month=" + t4.getMonth());
//		System.out.println("Advisor1=" + t4.advisor1().getName());

		
		PHD t5 = new PHD("Timmy",'m', 2003, 5, t1, t4);
		assertEquals("Timmy",t5.getName());
		assertEquals(2003,t5.getYear());
		assertEquals(5,t5.getMonth());
		assertEquals(true,t5.isMale());	

//		System.out.println("t5");
//		System.out.println("Gender=" + t5.isMale());
//		System.out.println("Name=" + t5.getName());
//		System.out.println("Year=" + t5.getYear());
//		System.out.println("Month=" + t5.getMonth());
	
		assertEquals(t1,t5.advisor1);
		assertEquals(t4,t5.advisor2);
//		System.out.println("Advisor1=" + t5.advisor1().getName());
//		System.out.println("Advisor2=" + t5.advisor2().getName());
		
		assertEquals(0,t5.numadvisees);
//		System.out.println("No.of Advisees for "+ t5.getName() + "=" + t5.numAdvisees());
		
		/*testD constructor,getter:name,gender,month,year,
		 *boolean:isMale,setAdvisor,numadvisees and comparison methods*/	
		PHD t6 = new PHD("Leo",'m', 2013, 6, t2, t5);
		assertEquals("Leo",t6.getName());
		assertEquals(2013,t6.getYear());
		assertEquals(6,t6.getMonth());
		assertEquals(true,t6.isMale());
		
//		System.out.println("t6");
//		System.out.println("Gender=" + t6.isMale());
//		System.out.println("Name=" + t6.getName());
//		System.out.println("Year=" + t6.getYear());
//		System.out.println("Month=" + t6.getMonth());
		
		assertEquals(t2,t6.advisor1);
		assertEquals(t5,t6.advisor2);
//		System.out.println("Advisor1=" + t6.advisor1().getName());
//		System.out.println("Advisor2=" + t6.advisor2().getName());
		
		assertEquals(1,t5.numadvisees);
		assertEquals(true,t4.gotBefore(t5));
		assertEquals(false,t4.gotBefore(t1));
		assertEquals(false,t5.gotBefore(t4));
		assertEquals(true,t4.arePHDSiblings(t5));
		assertEquals(false,t5.arePHDSiblings(t6));
		
//		System.out.println("No.of Advisees for "+ t1.getName() + "=" + t1.numAdvisees());
//		System.out.println("No.of Advisees for "+ t2.getName() + "=" + t2.numAdvisees());
//		System.out.println("No.of Advisees for "+ t3.getName() + "=" + t3.numAdvisees());
//		System.out.println("No.of Advisees for "+ t4.getName() + "=" + t4.numAdvisees());
//		System.out.println("No.of Advisees for "+ t5.getName() + "=" + t5.numAdvisees());
//		System.out.println("No.of Advisees for "+ t6.getName() + "=" + t6.numAdvisees());
	}
	
}
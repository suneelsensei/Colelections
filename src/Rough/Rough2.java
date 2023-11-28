package Rough;

import org.testng.annotations.*;

public class Rough2 {

	
	@BeforeMethod
	public void aaa() {
		
		System.out.println("bm");
	}
	@AfterMethod
	public void baa() {
		
		System.out.println("am");
	}
	@Test
	public void caa() {
		
		System.out.println("t1");
	}
	@Test
	public void daa() {
		
		System.out.println("t2");
	}
}

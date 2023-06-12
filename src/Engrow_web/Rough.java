package Engrow_web;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Rough {

	/*
	 * public static void main(String[] args) throws Exception {
	 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 * Application_workflow.driver = new ChromeDriver(); // URL
	 * Application_workflow.driver.get(
	 * "https://engrow-uat.senseitech.com/engrow-test-new");
	 * Application_workflow.driver.manage().window().maximize();
	 * Application_workflow.driver.manage().timeouts().implicitlyWait(20,
	 * TimeUnit.SECONDS);
	 * 
	 * // Enter User name
	 * Application_workflow.driver.findElement(By.xpath("//*[@type='text']")).
	 * sendKeys("100066"); // Enter Password
	 * Application_workflow.driver.findElement(By.xpath("//*[@type='password']")).
	 * sendKeys("Engrow@1");
	 * 
	 * Application_workflow.driver.findElement(By.xpath("//*[text()='Sign In']")).
	 * click();
	 * 
	 * Application_workflow.signout(); }
	 */
	/*
	 * @Test public void test() { for (int i = 1; i <= 10; i++) { List<String>
	 * values = Arrays.asList("YES", "NO", "NA"); Random r = new Random(); int
	 * randomitem = r.nextInt(values.size());
	 * System.out.println(values.get(randomitem)); } }
	 */
	
	
	@Test()
	public void test() {
		
		System.out.println("test1");
		
	}
	
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}
	
	@Test
	public void test4() {
		System.out.println("test4");
	}
	

}

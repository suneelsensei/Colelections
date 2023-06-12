package Encore_collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignOut {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		//URL
	   driver.get("https://encorecollections-test.senseitech.com/#/signin");
       driver.manage().window().maximize();
       //Enter User name
       driver.findElement(By.name("username")).sendKeys("sachinBM");
       //Enter Password
       driver.findElement(By.name("password")).sendKeys("Admin@123");
       //Click on Sign in
       	driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button")).click();
       Thread.sleep(2000);
// ========================================      
       
       //Sign Out menu
       
       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-toolbar/button[4]/span[1]/mat-icon")).click();
       Thread.sleep(6000);
       //Sign Out
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/button[1]/span")).click();
       
       System.out.println("============ Successfully signed out ============");
      
       //       driver.findElement(By.xpath("")).click();
	}

}
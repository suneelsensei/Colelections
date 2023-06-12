package Encore_collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Allocation {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		//URL
	   driver.get("https://encorecollections-test.senseitech.com");
       driver.manage().window().maximize();
       //Enter User name
       driver.findElement(By.name("username")).sendKeys("sharan");
       //Enter Password
       driver.findElement(By.name("password")).sendKeys("Admin@123");
       //Click on Sign in
       	driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button")).click();
       Thread.sleep(2000);
       //click on expand
       driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button/span[1]/mat-icon")).click();
       Thread.sleep(2000);
	
	
	//Allocation
       driver.findElement(By.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[3]/app-side-nav-list/a/div")).click();
	
       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/table/tbody/tr[1]/td[9]/span/span[3]/button")).click();
       
       
       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipt-generation/div/form/div/mat-card/mat-card-content[2]/div[1]/div[2]/mat-checkbox/label/span[2]")).click();
       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipt-generation/div/form/div/mat-card/mat-card-content[2]/table/tr/td[2]/mat-form-field/div/div[1]/div[2]/input")).sendKeys("sjd");
       
//       driver.findElement(By.xpath("")).click();
//       driver.findElement(By.xpath("")).click();
//       driver.findElement(By.xpath("")).click();
//       driver.findElement(By.xpath("")).click();
//       driver.findElement(By.xpath("")).click();
       
       
       
       
       
       
       
       
       
       
	}
}
//driver.findElement(By.xpath("")).click();
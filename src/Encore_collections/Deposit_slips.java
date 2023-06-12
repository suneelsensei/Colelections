package Encore_collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deposit_slips {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		//URL
	   driver.get("https://encorecollections-test.senseitech.com/#/signin");
       driver.manage().window().maximize();
       //Enter User name
       driver.findElement(By.name("usernameTxt")).sendKeys("sachinBM");
       //Enter Password
       driver.findElement(By.name("passwordTxt")).sendKeys("Admin@123");
       //Click on Sign in
       	driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button")).click();
       Thread.sleep(2000);
//=======================================================
       
//DEPOSIT SLIP
       
     //Click on Deposit tab
       driver.findElement(By.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[6]/app-side-nav-list/a/div")).click();
       
     //To close the expand button
       driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button")).click();
   
      //To click on All check box's
       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-deposit-slip-list/table/thead/tr/th[1]")).click();
       
       //Click on Submit Dep Slip
       
       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-deposit-slip-list/div[2]/button")).click();
       
       
       System.out.println("============ Successfully Deposit_slip_submitted ============");
       
       
       
       
       
	}
}

package Encore_collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Receipts {
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
       //======================================================================
       
     //RECEIPTS
     //Click on Receipts tab
     driver.findElement(By.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[5]/app-side-nav-list/a/div")).click();


     Thread.sleep(4000);
     //To open Filter
     //driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/div[1]/div/button[1]")).click();

     //Thread.sleep(2000);

     //To close the expand button
//     driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button")).click();


     //To select CASH Radio Button
     //driver .findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/div[2]/mat-radio-group/mat-radio-button[1]")).click();
     for(int a=1;a<=3;a++) {
     //To select CHEQUE Radio Button
 driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/div[2]/mat-radio-group/mat-radio-button["+a+"]")).click();


     //To select DD Radio Button
// driver.findElement(By.xpath("//html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/div[2]/mat-radio-group/mat-radio-button[3]")).click();



     //To select All check Box
 //driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/table/thead/tr/th[1]")).click();
     Thread.sleep(3000);
     int j = 3;
     // TO select required no.of check box's
     for(int i=1;i<=j;i+=2) {
         driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/table/tbody/tr["+i+"]/td[1]")).click();
         Thread.sleep(2000);
         }

     

     //click on Add to Dep Slip
    WebElement enable=driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav-content/div[2]/button"));
    
     Thread.sleep(3000);

     if(enable.isEnabled() == true)
     {
    	 enable.click();
    	 Thread.sleep(3000);
  //To select the Bank Account
 driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav/div/app-deposit-slip/div/mat-card[2]/form/div/div/mat-form-field[1]/div/div[1]/div/mat-select")).click();

     //To select HDFC
     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[1]")).click();

     //To select AXIS
     //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[2]")).click();

     //Click on Save
 driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-receipts/mat-sidenav-container/mat-sidenav/div/app-deposit-slip/div/mat-card[2]/form/div/button")).click();
            
       System.out.println("DEPOSIT_SLIP_CREATED Successfully");     
     }
     else {
    System.out.println("No Deposite Sips to create");
     }
     
     }	
	}
}

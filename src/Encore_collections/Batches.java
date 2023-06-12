package Encore_collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Batches {
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
       //click on expand
       driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button/span[1]/mat-icon")).click();
       Thread.sleep(2000);
//============================================================================================================       
//BATCHES
       
       //click on Batches
       driver.findElement(By.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[4]/app-side-nav-list/a/div")).click();
     
       
       int j =  3;                    //(Provide j ,For 1 check box = 1 ,2 check box = 3,3 check box = 5 ,......)

       
       //click on 1st receipt
       Thread.sleep(2000);
       
       for(int i=1;i<=j;i+=2) {
    	   Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-deposit-batches/mat-sidenav-container/mat-sidenav-content/div/table/tbody/tr["+i+"]/td[7]/span[1]/button")).click();
 //click on 2nd receipt
//driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-deposit-batches/mat-sidenav-container/mat-sidenav-content/div/table/tbody/tr[3]/td[7]/span[1]/button")).click();

//Select the check box all
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-batch-receipts/table/thead/tr/th[1]")).click();

Thread.sleep(2000);
       //click on Acknowledge
driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-batch-receipts/div[2]/div[1]/button")).click();
Thread.sleep(4000);
       //To confirm the pop-up
driver.findElement(By.xpath("//*[@id='yes-button']")).click();
Thread.sleep(4000); 

//Click on Back button
driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-batch-receipts/div[1]/div/button")).click();

System.out.println("BATCH_ACKNOWLEDGED Successfully");

       }
}
}
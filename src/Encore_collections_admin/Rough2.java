package Encore_collections_admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rough2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();
		// Enter User name
		//Enter User name
	       driver.findElement(By.name("username")).sendKeys("admin@123");
	       //Enter Password
	       driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button"))
				.click();
		Thread.sleep(2000);
// ========================================  

		// Click on maximize
		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-toolbar/button[3]")).click();
		Thread.sleep(5000);

		// Click on Admin
		driver.findElement(By
				.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[10]/app-side-nav-list/a/div"))
				.click();
		Thread.sleep(2000);

		// Click on User
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[1]/mat-accordion/mat-expansion-panel/div/div/mat-nav-list/div[4]/a/div"))
				.click();
		Thread.sleep(3000);

		// Click on create_User
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user/div/button[1]"))
				.click();
		Thread.sleep(2000);
//-------------------------------------------------------------------------------
//		for(int i=5;i<=9;i++)
//		{
		//Click on Role
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[1]/div/mat-grid-tile[1]/div/div/div/mat-form-field[5]/div/div[1]/div/mat-select")).click();

//		if(i==5)
//		{
		
		
		int list=driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option")).size();
		
		for(int j=1;j<=list;j++) {
			String role ="Agent";
		//Select Role
		WebElement Rtype=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option["+j+"]/span"));
		if((Rtype.getText()).equals(role))
		{
			Rtype.click();
			break;
		}
		
		}
//								}

	}

}

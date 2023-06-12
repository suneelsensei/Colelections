package Encore_collections_admin;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class scroll_down {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();
		// Enter User name
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/mat-form-field[1]/div/div[1]/div[3]/input"))
				.sendKeys("admin@123");
		// Enter Password
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/mat-form-field[2]/div/div[1]/div[3]/input"))
				.sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button"))
				.click();
		Thread.sleep(2000);
//========================================  

		// Click on maximize
//		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-toolbar/button[3]")).click();
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
//===============================================
		
		
	//click on Active button
		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/div/mat-card-actions/mat-slide-toggle[2]/label")).click();
		
		//click on submit
	driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-card-actions/button[1]")).click();
		
		
//	WebElement submit= driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-card-actions/button[1]"));
//		
//		if(submit.isEnabled()) {
//			submit.click();
//		}
//		else {
//			System.out.println("Submit button is disabled");
//		}
		
		
		
		
		
		
		
		
		
		
	}
}

package Encore_collections;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {
	static String username = "admin@123";
	static String filepath = "C:\\Users\\Dell\\Downloads\\Allocations_2022-Nov-07_12-56-56.xlsx";

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();
		// Enter User name
		driver.findElement(By.name("username")).sendKeys(username);
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button"))
				.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on allocation
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav/div/mat-nav-list/app-side-nav/mat-nav-list/div[3]/app-side-nav-list/a/div"))
				.click();

		// click on bulk upload
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-collection-item/mat-sidenav-container/mat-sidenav-content/div[2]/button[4]"))
				.click();
		Thread.sleep(3000);
		// upload file
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-bulk-upload-allocation/div[2]/mat-card[2]/mat-card-content/table/div/tr/td[2]/form/input"))
				.sendKeys(filepath);

		// Click on upload
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-bulk-upload-allocation/div[2]/mat-card[2]/mat-card-content/table/div/tr/td[3]/mat-card-actions/button"))
				.click();

	}

}

//driver.findElement(By.xpath(""));

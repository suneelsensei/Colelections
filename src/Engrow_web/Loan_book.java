package Engrow_web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loan_book {
	static WebDriver driver;
	static String url = "https://engrow-uat.senseitech.com/engrow-uat-new";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// URL
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Enter User name
		driver.findElement(By.xpath("//*[@name='usernameTxt']")).sendKeys("100030");
		// Enter Password
		driver.findElement(By.xpath("//*[@name='passwordTxt']")).sendKeys("Engrow@1");

		// Click on sign IN
		driver.findElement(By.xpath("//*[@class='button button4']")).click();

		// Click on Applications
		driver.findElement(By.xpath("//*[text()='source']")).click();

//		for (int k = 1; k > 0; k++) {

		int count = driver.findElements(By.xpath("//tbody[@role='rowgroup']/tr")).size();

		for (int i = 1; i < count; i++) {
			try {
				driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + i + "]")).click();
			} catch (Exception e) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + i + "]")).click();
			}

			driver.findElement(By.xpath("//*[text()='launch']")).click();

			Thread.sleep(6000);
//				for (int j = 10; j > 0; j++) {

			// Click on OPERATIONS
			/*
			 * String text = driver.findElement(By.xpath(
			 * "/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/eng-application-details/mat-sidenav-container/mat-sidenav-content/div/div/div[1]/mat-accordion/mat-expansion-panel["
			 * + j + "]/mat-expansion-panel-header/span[1]/mat-panel-title")) .getText(); if
			 * (text.equals("OPERATIONS")) {
			 */
			driver.findElement(By.xpath("//*[text()='OPERATIONS']")).click();
			Thread.sleep(2000);
			// Click on Book Loan in Side nav
			driver.findElement(By.xpath("//*[text()='BOOK LOAN']")).click();
//				break;
//			}
//				}

			Thread.sleep(2000);
			try {
			driver.findElement(By.xpath("//*[text()='Loan already booked']"));
			Proceedtonextstage(); 
			i -= 1;
			}catch (Exception e) {}
			driver.findElement(By.xpath("//*[text()='source']")).click();
			/*
			 * if (next.isDisplayed()) { Proceedtonextstage(); i -= 1; }
			 * driver.findElement(By.xpath("//*[text()='source']")).click();
			 */		}
//		}

		
		
	}

	public static void Proceedtonextstage() throws Exception {
		Thread.sleep(2000);
		// Click on Decision card
		driver.findElement(By.xpath("//*[text()='next_plan']")).click();
		// Click on Proceed Radio button
		driver.findElement(By.xpath("//*[@value='proceed']/label")).click();
		// Click on OK
		driver.findElement(By.xpath("//span[text()='REMARKS']//following-sibling::span")).click();
		Thread.sleep(3000);
	}
	
}
//driver.findElement(By.xpath("")).click();

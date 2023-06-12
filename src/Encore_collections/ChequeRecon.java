package Encore_collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChequeRecon {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();

		// -------------------------------

		// Enter User name
		driver.findElement(By.name("usernameTxt")).sendKeys("operational");
		// Enter Password
		driver.findElement(By.name("passwordTxt")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div/button"))
				.click();
		Thread.sleep(2000);

		// click on Cheque Recon tab
		driver.findElement(By
				.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[8]/app-side-nav-list/a/div"))
				.click();

		// To close the expand button
		driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button")).click();
		Thread.sleep(5000);

		// click on filter
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[1]/div/button[1]"))
				.click();
		Thread.sleep(3000);
		//cancel the filter
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[1]/form/mat-form-field[3]/div/div[1]/div[2]/button"))
				.click();
		Thread.sleep(3000);

		// To select All check box's
//       driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/table/thead/tr/th[1]")).click();

		// To select required no.of check box's
//       Provide j ,For 1 check box = 1 ,2 check box = 3,3 check box = 5 ......
		int j = 1;
		for (int i = 1; i <= j; i += 2) {
			driver.findElement(By.xpath(
					"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/table/tbody/tr["
							+ i + "]/td[1]"))
					.click();
			Thread.sleep(2000);
		}

		// Click on Cleared in Bank
		WebElement ClearedInBank =driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[2]/button[1]"))
				;
		
		if (ClearedInBank.isEnabled() == true) {
			ClearedInBank.click();
			System.out.println("================ CHEQUE Successfully Cleared in Bank ================");
		} else {
			System.out.println("No CHEQUE receipts selected");
		}

		

		// Click on Reject
//     driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[2]/button[2]")).click();

//       System.out.println("================ CHEQUE Successfully Rejected ================");
	}
}

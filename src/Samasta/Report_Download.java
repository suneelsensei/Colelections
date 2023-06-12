package Samasta;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Report_Download {
	static String url = "https://samasta-test.senseitech.com/mavrc-v2_8/#/signin";
	static String username = "sensei-support";
	static String password = "admin";

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(3000);
		driver.findElement(By.name("usernameTxt")).sendKeys(username);
		driver.findElement(By.name("passwordTxt")).sendKeys(password);

		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-login/div/div/mat-card/mat-card-content/form/div/button"))
				.click();

		// click on BMT Dashboard
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav/div/ig-multi-level-menu/mat-nav-list/div[3]/ig-menu-item/a/div"))
				.click();

		// Click on Questionarie Report
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav/div/ig-multi-level-menu/mat-nav-list/div[3]/ig-menu-item/div/ig-menu-item[1]/a/div"))
				.click();

		// State
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/div[1]/ng-multiselect-dropdown"))
				.click();
		// Select All
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]"))
				.click();

		Thread.sleep(3000);
		// Branches
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/div[2]/ng-multiselect-dropdown"))
				.click();

		// Select all
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/div[2]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]"))
				.click();

		// From date
		try {
			driver.findElement(By.name("fromDateFilter")).sendKeys("11/21/2022");
		} catch (Exception e) {
			Actions co_ord = new Actions(driver);
			co_ord.moveByOffset(500, 500).click().perform();
			driver.findElement(By.name("fromDateFilter")).sendKeys("11/21/2022");
		}
		// To date
		try {
			driver.findElement(By.name("toDateFilter")).sendKeys("11/22/2022");
			;
		} catch (Exception e) {
			Actions co_ord1 = new Actions(driver);
			co_ord1.moveByOffset(100, 100).click().perform();
			driver.findElement(By.name("toDateFilter")).sendKeys("11/22/2022");
		}

		Thread.sleep(3000);
		// Question type
		driver.findElement(By.xpath(
				"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/mat-form-field[3]/div/div[1]"))
				.click();

		List<WebElement> size = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option"));
//		System.out.println(size.size());
		for (int i = 1; i <= size.size(); i++) {
			System.out.println(
					driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + i + "]/span"))
							.getText());
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + i + "]")).click();
			// Download
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/div[3]/button[1]"))
					.click();
			Thread.sleep(3000);
			// Question type
			driver.findElement(By.xpath(
					"/html/body/app-root/ig-layout/ig-layout-two-column/div/mat-sidenav-container/mat-sidenav-content/app-questionaire-report-creation/mat-card/mat-card-content/form/div/mat-form-field[3]/div/div[1]"))
					.click();
		}

	}

}
//driver.findElement(By.xpath("")).click();
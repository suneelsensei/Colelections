package Encore_collections;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cash_cheque {
	static WebDriver driver;

	public static void clearinbank() {
		int j = 1;
		for (int i = 1; i <= j; i++)
			// To select required no.of check box's
			driver.findElement(By.xpath("(//*[@role='cell']/span/mat-checkbox)[" + i + "]")).click();

		// Click on Cleared in Bank

		WebElement ClearedInBank = driver.findElement(By.xpath("//*[text()='Cleared In Bank']"));

		if (ClearedInBank.isEnabled() == true) {
			ClearedInBank.click();
			System.out.println("================ Successfully Cleared in Bank ================");
		} else {
			System.out.println("No receipts selected");
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// URL
		driver.get("https://encorecollections-test.senseitech.com/#/signin");
		driver.manage().window().maximize();

		// -------------------------------

		// Enter User name
		driver.findElement(By.name("username")).sendKeys("operational");
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath("//*[text()='Sign In Securely']")).click();
		Thread.sleep(3000);

		// click on Cash Recon tab
		driver.findElement(By.xpath("//*[text()='CASH RECON']")).click();
		clearinbank();

		// click on Cheque Recon
		driver.findElement(By.xpath("//*[text()='CHEQUE RECON']")).click();
		ArrayList<String> a = new ArrayList<String>();
		a.add("CHEQUE");
		a.add("DD");
		for (String Recon : a) {
			driver.findElement(By.xpath("//mat-radio-button[@value=" + Recon + "]")).click();
			clearinbank();
		}

		/*
		 * int d = 7; // (for only cash change d=7 and c=7, for both cash&cheque d=7,c=8
		 * ) int c = 8; // (for only cheque d=8 and c=8) // CASH/Cheque RECON
		 * ArrayList<String> al = new ArrayList<String>(); al.add("cash");
		 * al.add("cheque");
		 * 
		 * for (int b = d; b <= c; b++) { // click on Cash/Cheque Recon tab
		 * driver.findElement(By.xpath(
		 * "//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[" + b +
		 * "]/app-side-nav-list/a/div")).click();
		 * 
		 * // To close the expand button
		 * driver.findElement(By.xpath("//*[@id='sidenav']/div/div/button")).click();
		 * Thread.sleep(3000);
		 * 
		 * if (al.get(b - 7) == "cheque") { // click on filter
		 * driver.findElement(By.xpath(
		 * "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[1]/div/button[1]"
		 * )) .click(); Thread.sleep(3000); // clear the filter
		 * driver.findElement(By.xpath(
		 * "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cheque-deposit/div[1]/form/mat-form-field[3]/div/div[1]/div[2]/button"
		 * )) .click(); Thread.sleep(3000); }
		 * 
		 * // To select All check box's // driver.findElement(By.xpath(
		 * "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cash-deposit/table/thead/tr/th[1]"
		 * )).click();
		 * 
		 * // To select required no.of check box's int j = 1;
		 * 
		 * for (int i = 1; i <= j; i += 2) { driver.findElement( By.xpath(
		 * "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-"
		 * + al.get(b - 7) + "-deposit/table/tbody/tr[" + i + "]/td[1]")) .click();
		 * 
		 * //
		 * "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-cash-deposit/table/tbody/tr["
		 * +i+"]/td[1]")).click(); Thread.sleep(2000);
		 * 
		 * // Click on Cleared in Bank WebElement ClearedInBank = driver.findElement(
		 * By.xpath(
		 * "/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-"
		 * + al.get(b - 7) + "-deposit/div[2]/button[1]"));
		 * 
		 * if (ClearedInBank.isEnabled() == true) { ClearedInBank.click(); System.out.
		 * println("================ Successfully Cleared in Bank ================"); }
		 * else { System.out.println("No receipts selected"); }
		 */
		// Click on Reject
//	    WebElement RejectInBank = driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-"+a1.get(b-7)+"-deposit/div[2]/button[2]"));
//				
//				if(RejectInBank.isEnabled()==true) {
//					RejectInBank.click();
//				
//				// System.out.println("================ Successfully Rejected
//				// ================");
//				}
//				else {
//					System.out.println("No receipts selected");
//				}
//			}
//}

	}

}

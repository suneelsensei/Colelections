package Encore_collections_admin;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class User_Creation {

	static String url = "https://encorecollections-test.senseitech.com/#/signin";
	static String username = "sharan";
	// Enter User_name/First_name/Last_name/Email
	static ArrayList<String> name = new ArrayList<String>();
	static {

		// First_name
		name.add("Nach");
		// Last_name
		name.add("upload");
		// User_name
		name.add("system");
		// Email
		name.add("system@yopmail.com");
		// dummy
		name.add("");
		name.add("");
		name.add("");
		// Password
		name.add("Admin@123");

	}

	static ArrayList<String> string = new ArrayList<String>();
	static {
		// Departement
		string.add("System");
		// Designation
		string.add("SYS");
		// Address
		string.add("Amet");
		// dummy
		string.add("");
		string.add("");
		// Pincode
		string.add("488965");
		// Contact Number
		string.add("8564777856");
		// Confirm Password
		string.add("Admin@123");
	}

	static String role = "abc";
	static String branch_set = "ALL-ALL";
	static String branch_code = "HO-HO";
	static String user_type = "Employee";
	static String Agent = "Suneel";
	static String State = "Karnataka";
	static String City = "Jalageri";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// URL
		driver.get(url);
		driver.manage().window().maximize();
		// Enter User name
		driver.findElement(By.name("username")).sendKeys(username);
		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Admin@123");
		// Click on Sign in
		driver.findElement(By.xpath(
				"//*[text()='Sign In Securely']"))
				.click();
		Thread.sleep(1500);
		WebElement sms = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/div/div/simple-snack-bar/span"));
		System.out.println(sms.getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// ========================================  

		// Click on maximize
//		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-toolbar/button[3]")).click();
		Thread.sleep(3500);

		// Click on Admin
		driver.findElement(By
				.xpath("//*[@id='sidenav']/div/mat-nav-list/app-side-nav/mat-nav-list/div[11]/app-side-nav-list/a/div"))
				.click();

		// Click on Access Matrix
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[1]/mat-accordion/mat-nav-list[2]/mat-expansion-panel"))
				.click();
		Thread.sleep(2000);
		// Click on User
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[1]/mat-accordion/mat-nav-list[2]/mat-expansion-panel/div/div/span[2]"))
				.click();

		// Click on create_User
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user/div/button[1]"))
				.click();

		for (int i = 1; i <= 8; i++) {
			if (i != 5 && i != 6 && i != 7) {
				driver.findElement(By.xpath(
						"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[1]/div/mat-grid-tile[1]/div/div/div/mat-form-field["
								+ i + "]/div/div[1]/div/input"))
						.sendKeys("" + name.get(i - 1) + "");
			}
		}

		for (int j = 1; j <= 7; j++) {
			if (j != 4 && j != 5) {
				driver.findElement(By.xpath(
						"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[1]/div/mat-grid-tile[2]/div/div/div[1]/mat-form-field["
								+ j + "]/div/div[1]/div/input"))
						.sendKeys("" + string.get(j - 1) + "");
			}
		}

		// Confirm Password
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[1]/div/mat-grid-tile[2]/div/div/div[2]/mat-form-field/div/div[1]/div[3]/input"))
				.sendKeys("" + string.get(7) + "");

		for (int i = 5; i <= 7; i++) {
			Thread.sleep(2000);
			// Click on drop-downs
			driver.findElement(By.xpath(
					"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[1]/div/mat-grid-tile[1]/div/div/div/mat-form-field["
							+ i + "]/div/div[1]/div/mat-select"))
					.click();

			int size = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option")).size();

			if (i == 5) {
				for (int j = 1; j <= size; j++) {

					// Select Role
					WebElement Rtype = driver
							.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j + "]/span"));
					if ((Rtype.getText()).equals(role)) {
						Rtype.click();
						break;
					}

				}
			} else if (i == 6) {
				for (int j = 1; j <= size; j++) {

					// Select Branch Set Code
					WebElement Btype = driver
							.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j + "]/span"));
					if ((Btype.getText()).equals(branch_set)) {
						Btype.click();
						break;
					}
				}
			}

			else if (i == 7) {
				for (int j = 1; j <= size; j++) {

					// Select Branch Code
					WebElement Bctype = driver
							.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j + "]/span"));
					if ((Bctype.getText()).equals(branch_code)) {
						Bctype.click();
						break;
					}
				}
			}
		}

		// Click on User_type
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[2]/div/div[1]/mat-grid-tile/div/mat-form-field/div/div[1]/div/mat-select/div"))
				.click();

		int Usize = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option")).size();

		for (int j = 1; j <= Usize; j++) {

			// Select User_type
			WebElement Utype = driver
					.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j + "]/span"));
			if ((Utype.getText()).equals(user_type)) {
				if ((Utype.getText()).equals("Agency")) {
					Utype.click();
					// Click on Agent

					driver.findElement(By.xpath(
							"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[2]/div/div[2]/mat-grid-tile/div/mat-form-field/div/div[1]/div/mat-select/div"))
							.click();

					int Asize = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option")).size();

					for (int j1 = 1; j1 <= Asize; j1++) {

						// Select Agent
						WebElement Atype = driver.findElement(
								By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j1 + "]/span"));
						if ((Atype.getText()).equals(Agent)) {
							Atype.click();
							break;
						}
					}
					break;
				} else {
					Utype.click();
					break;
				}
			}

		}

		for (int i = 4; i <= 5; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-grid-list[1]/div/mat-grid-tile[2]/div/div/div[1]/mat-form-field["
							+ i + "]/div/div[1]/div/mat-select/div"))
					.click();

			int size = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option")).size();

			if (i == 4) {
				for (int j = 1; j <= size; j++) {

					// Select state
					WebElement Stype = driver
							.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j + "]/span"));
					if ((Stype.getText()).equals(State)) {
						Stype.click();
						break;
					}

				}
			} else if (i == 5) {
				for (int j = 1; j <= size; j++) {

					// Select state
					WebElement Stype = driver
							.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[" + j + "]/span"));
					if ((Stype.getText()).equals(City)) {
						Stype.click();
						break;
					}

				}
			}

		}

		// click on Active button
		driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/div/mat-card-actions/mat-slide-toggle[2]/label"))
				.click();

		// click on submit
		WebElement submit = driver.findElement(By.xpath(
				"/html/body/app-root/app-ig-layout/div/mat-sidenav-container/mat-sidenav-content/app-admin/div/div/div[2]/app-user-edit/mat-card/mat-card-content/form/mat-card-actions/button[1]"));

		if (submit.isEnabled()) {
			submit.click();

			WebElement sms1 = driver.findElement(
					By.xpath("/html/body/div[2]/div/div/snack-bar-container/div/div/simple-snack-bar/span"));
			System.out.println(sms1.getText());
		} else {
			System.out.println("Error Occured");
		}

	}

}

package Encore_collections_admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class userC {

	static String url = "https://encorecollections-test.senseitech.com/#/signin";
	static String username = "sharan";
	// Enter User_name/First_name/Last_name/Email
	static List<String> name = new ArrayList<String>();

	/*
	 * static Map<String, String> keyVal = new HashMap<>(); static {
	 * keyVal.put("firstName", "Nach"); keyVal.put("lastName", "Kulli");
	 * keyVal.put("role", "Agent"); }
	 */
	static {
		// First_name
		name.add("samastha");
		// Last_name
		name.add("BM");
		// User_name
		name.add("samasthabm");
		// Email
		name.add("samasthabm@yopmail.com");
		// Password
		name.add("Admin@123");
		// Departement
		name.add("RO");
		// Designation
		name.add("RO");
		// Address
		name.add("Bangalore");
		// Pincode
		name.add("488965");
		// Contact Number
		name.add("6564777856");
		// Confirm Password
		name.add("Admin@123");
	}
	static List<String> dd = new ArrayList<String>();
	static {
		// role
		dd.add("Agent");
		// branch_set
		dd.add("HO-HO");
		// branch_code
		dd.add("HO-HO");
		// state
		dd.add("Karnataka");
		// city
		dd.add("Jalageri");
		// user_type
		dd.add("Employee");
		// Agent
		dd.add("Suneel");
	}

	/*
	 * static Map<String, String> keyVal = new HashMap<>(); static {
	 * keyVal.put("firstName", "Nach"); keyVal.put("lastName", "Kulli");
	 * keyVal.put("role", "Agent");
	 * 
	 * }
	 */

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
		driver.findElement(By.xpath("//*[text()='Sign In Securely']")).click();
		Thread.sleep(1500);

		WebElement sms = driver.findElement(By.xpath("//*[@role='alertdialog']"));
		System.out.println(sms.getText());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// ========================================  

		// Click on maximize
//		driver.findElement(By.xpath("/html/body/app-root/app-ig-layout/div/mat-toolbar/button[3]")).click();
		Thread.sleep(3500);

//		String xpath = "//*[@name='%s']";

		// Click on Admin
		driver.findElement(By.xpath("//*[text()='ADMIN']")).click();

		// Click on Access Matrix
		driver.findElement(By.xpath("//*[text()='ACCESS MATRIX']")).click();
		Thread.sleep(2000);
		// Click on User
		driver.findElement(By.xpath("//*[text()='USER']")).click();

		// Click on create_User
		driver.findElement(By.xpath("//*[@title='Create']")).click();
		/*
		 * for (String key : keyVal.keySet()) {
		 * 
		 * driver.findElement(By.xpath(String.format(xpath,l̥
		 * key))).sendKeys(keyVal.get(key)); }
		 */

		/*
		 * String dropdownXpath = "(//*[@role='combobox'])"; AtomicInteger count = new
		 * AtomicInteger(0);
		 * driver.findElements(By.xpath(dropdownXpath)).forEach(dropdown -> {
		 * dropdown.click(); driver.findElement(
		 * By.xpath(String.format("//span[contains(text(),'%s')]",
		 * dd.get(count.getAndIncrement())))).click(); if
		 * (dd.get(count.getAndIncrement()).contains("Suneel")) {
		 * driver.findElements(By.xpath(dropdownXpath)).get(driver.findElements(By.xpath
		 * (dropdownXpath)).size()) .click();
		 * driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]",
		 * dd.get(dd.size() - 1)))) .click(); } });
		 */

		String Xpath1 = "(//*[contains(@id,'mat-input')])";
		int elements = driver.findElements(By.xpath(Xpath1)).size();
		for (int i = 1; i <= elements; i++) {
			driver.findElement(By.xpath(Xpath1 + "[" + i + "]")).sendKeys(name.get(i - 1));
		}

		String Xpath2 = "(//*[@role='combobox'])";
		int dropdowns = driver.findElements(By.xpath(Xpath2)).size();
		if (dd.contains("Agency")) {
			dropdowns += 1;
		}
		for (int j = 1; j <= dropdowns; j++) {
			Thread.sleep(1000);
			driver.findElement(By.xpath(Xpath2 + "[" + j + "]")).click();

			driver.findElement(By.xpath("//*[text()=' " + dd.get(j - 1) + " ' or text()=' " + dd.get(j - 1) + "']"))
					.click();
			/*
			 * int size = driver.findElements(By.xpath("//*[@role='option']")).size(); for
			 * (int k = 1; k <= size; k++) { WebElement type =
			 * driver.findElement(By.xpath("(//*[@role='option']/span)[" + k + "]")); if
			 * ((type.getText()).equalsIgnoreCase(dd.get(j - 1))) { type.click(); break; } }
			 */ }

//		System.exit(0);
		// click on Active button
		driver.findElement(By.name("activated")).click();

		// click on submit
		WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));

		if (submit.isEnabled()) {
			submit.click();

			System.out.println(driver.findElement(By.xpath("//*[@role='alertdialog']")).getText());

		} else {
			System.out.println("Error Occured");
		}
	}
}

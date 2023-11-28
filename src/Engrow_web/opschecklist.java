package Engrow_web;

import static org.testng.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class opschecklist {

	static WebDriver driver;
	static String url = "https://engrow-uat.senseitech.com/engrow-test-new";
	static String username = "100030";
	static String password = "Engrow@1";
	static String name = "Shashi V";
	static int options;

	@BeforeTest
	public static void launchbrowser() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		driver.get(url);
	}

	@Test(priority = -1)
	public static void signin() {
		// Enter credentials
		driver.findElement(By.name("usernameTxt")).sendKeys(username);
		driver.findElement(By.name("passwordTxt")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		String actual = driver.findElement(By.xpath("//*[text()='loan origination solution']")).getText();
		assertEquals(actual, "loan origination solution");
	}

	@Test(dependsOnMethods = { "signin" })
	public static void moveto_opschecklist() throws Exception {
		driver.findElement(By.xpath("//*[@ng-reflect-message='APPLICATIONS']")).click();
		driver.findElement(By.xpath("//*[text()='" + name + "']")).click();
		driver.findElement(By.xpath("//*[@mattooltip='Open Application']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='OPERATIONS']")).click();
		driver.findElement(By.xpath("//*[text()='OPS CHECKLIST']")).click();
		try {
		WebElement addcl = driver.findElement(By.xpath("//*[@mattooltip='Add New Checklist']"));
			addcl.click();
			driver.findElement(By.xpath("//*[text()='Ok']")).click();
		}catch (Exception e) {}
		driver.findElement(By.xpath("//*[@mattooltip='Edit']")).click();
		options = driver.findElements(By.xpath("//mat-radio-group[@ng-reflect-fx-layout='row']")).size();
	}

	@Test(dependsOnMethods = { "moveto_opschecklist" })
	public static void selectingchecklist() {

		for (int i = 1; i <= options; i++) {
			List<String> values = Arrays.asList("YES", "NO", "NA");
			Random r = new Random();
			int randomitem = r.nextInt(values.size());
			driver.findElement(By.xpath("(//*[@ng-reflect-value='" + values.get(randomitem) + "'])[" + i + "]"))
					.click();
		}

		driver.findElement(By.xpath("//*[@mattooltip='Save']")).click();

	}

}

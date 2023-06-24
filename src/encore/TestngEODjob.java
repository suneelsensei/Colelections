package encore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestngEODjob {

	int count = 2;
	String url="https://encore-demo.senseitech.com/encore-client/#/login";
	String username="suneel";
	String password="Suneel@1234";
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void login() {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		WebDriverWait signin = new WebDriverWait(driver, 100);
		signin.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit']")));
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Test(dependsOnMethods = { "login" }/*, invocationCount = 2*/)
	public void runeod() {
		for (int i = 1; i <= count; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 100);

			driver.findElement(By.xpath("//*[text()=' notifications']")).click();
			driver.findElement(By.xpath("//*[@class='btn-dark-blue w-full']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='btn-dark-blue']")));
			driver.findElement(By.xpath("//*[@class='btn-dark-blue']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@class='COMPLETED font-bold text-xs']")));
			driver.findElement(By.xpath("//*[@mattooltip='Remove from list']")).click();
			System.out.println(i);
		}

	}

	@AfterTest()
	public void exit() {
		driver.quit();

	}
}
